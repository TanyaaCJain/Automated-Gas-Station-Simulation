package tanyapetrolpump;

import java.util.ArrayList;
import java.util.Random;

import tanyapetrolpump.models.FuelType.*;
import tanyapetrolpump.models.Transaction.*;
import tanyapetrolpump.models.Vehicle.*;
import tanyapetrolpump.Pump;

public abstract class Data {

    private static Random rng = new Random();
    public static ArrayList<Vehicle> queue = new ArrayList<>();
    public static ArrayList<Vehicle> atPumpVehicles = new ArrayList<>();
    public static ArrayList<Vehicle> fuelledVehicles = new ArrayList<>();

    // list of each fuelling transaction (Vehicle type, number of litres, pump number)
    public static ArrayList<Transaction> transactions = new ArrayList<>();

    public static FuelType generateFuelObject(String fuelType) {
        FuelType fuelTypeObject = null;
        switch(fuelType) {
            case "Unleaded":
                fuelTypeObject = new Unleaded();
                break;
            case "Diesel":
                fuelTypeObject = new Diesel();
                break;
            case "LPG":
                fuelTypeObject = new LPG();
                break;
        }
        return fuelTypeObject;

    } 
    static void generateVehicle() {
        // To not generate vehicles if the queue at the gas station is at its maximum
        if (queue.size() == Config.QUEUE_MAX_VEHICLES) {
            return;
        }

        String[] plateNumbers = { "DEL", "HYD", "LON", "NYC", "UAE", "THB" };
        String plateNumber = plateNumbers[ rng.nextInt( plateNumbers.length ) ] + " " + String.format( "%3d", rng.nextInt( 1000 ) );
        String[] vehicleTypes = {"Car", "Van", "HGV"};
        String vehicleType = vehicleTypes[ rng.nextInt( vehicleTypes.length ) ];
        String[] fuelTypes = {"LPG", "Diesel", "Unleaded"};
        Vehicle vehicle = null;
        switch ( vehicleType ) {
            case "Car":
                String fuelTypeCar = fuelTypes[ rng.nextInt( fuelTypes.length ) ];
                vehicle = new Car( plateNumber, generateFuelObject(fuelTypeCar) );
                break;
            case "Van":
                String fuelTypeVan = fuelTypes[ rng.nextInt( 2 ) ];
                vehicle = new Van( plateNumber, generateFuelObject(fuelTypeVan) );
                break;
            case "HGV":
                // HGV only run on Diesel which is defined in the constructor
                vehicle = new HGV(plateNumber);
                break;
        }
        queue.add(vehicle);
    }

    static void checkQueue(Pump gasStationMap[][]) {
        /* 
         * No changes are made if one of the following two criterias are met:
         * a. if all the pumps are busy (maximum possible vehicles are present at the pump)
         * b. if no vehicles are waiting to be fuelled in the queue
         */
        if (atPumpVehicles.size() == Config.FUEL_MAX_VEHICLES || queue.size() == 0) {
            return;
        }
        while (queue.size() > 0) {
            Pump tempEmptyPump = new Pump();
            for (int lane = 0, flag = 0; lane < 3 && flag == 0; lane++) {
                for (int pump = 2; pump >= 0 && flag == 0; pump--) {
                    if (gasStationMap[lane][pump].getPumpUsage() == false) {
                        switch(pump) {
                            case 0: tempEmptyPump = gasStationMap[lane][pump];
                                    flag = 1;
                                    break;
                            case 1: if (gasStationMap[lane][0].getPumpUsage() == false) {
                                        tempEmptyPump = gasStationMap[lane][pump];
                                        flag = 1;
                                    }
                                    break;
                            case 2: if (gasStationMap[lane][0].getPumpUsage() == false && gasStationMap[lane][1].getPumpUsage() == false) {
                                        tempEmptyPump = gasStationMap[lane][pump];
                                        flag = 1;
                                    }
                                    break;
                            default: break;
                        }
                    }
                }
            }

            Vehicle vehicle = queue.get(0);
            queue.remove(0);

            tempEmptyPump.FuelVehicle(vehicle);

            // Loop is broken if all the pumps are busy (maximum possible vehicles are present at the pump)
            if (atPumpVehicles.size() == Config.FUEL_MAX_VEHICLES) {
                break;
            }
        }
    }
}
