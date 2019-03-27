package tanyapetrolpump;

//import tanyapetrolpump.models.Vehicle.Car;
import tanyapetrolpump.models.Transaction.*;
//import tanyapetrolpump.models.Vehicle.Van;
import tanyapetrolpump.models.Vehicle.*;
import tanyapetrolpump.Pump;

import java.util.ArrayList;
import java.util.Random;

public abstract class Data {

    private static Random rng = new Random();
    /*
     * public static final boolean gasStation[][] = new boolean[3][3]; for(
     * boolean[] row: gasStation) { Arrays.fill( row, false ); }
     */
    // The main variable of Gas Station to form the 3 lanes, each containing 3 pumps
    //TanyaPetrolPump gasStation = new TanyaPetrolPump(5, 5);
    //gasStation.initGasStationMap();

    //public static Pump gasStation[][] = new Pump[3][3];
    
    // public static ArrayList<ArrayList<Pump>> gasStation = new
    // ArrayList<ArrayList<Pump>>();
    public static ArrayList<Vehicle> queue = new ArrayList<>();
    public static ArrayList<Vehicle> atPumpVehicles = new ArrayList<>();
    public static ArrayList<Vehicle> fuelledVehicles = new ArrayList<>();

    // list of each fuelling transaction (Vehicle type, number of litres, pump
    // number)
    public static ArrayList<Transaction> transactions = new ArrayList<>();

    // private static Random rng = new Random();

    static void generateVehicle() {
        // To not generate vehicles if the queue at the gas station is at its maximum
        if (queue.size() == Config.QUEUE_MAX_VEHICLES) {
            return;
        }

        String[] plateNumbers = { "DEL", "HYD", "LON", "NYC", "UAE", "THB" };
        String plateNumber = plateNumbers[ rng.nextInt( plateNumbers.length ) ] + " " + String.format( "%3d", rng.nextInt( 1000 ) );
        // int fuelLevels = 2;
        Vehicle vehicle = null;
        vehicle = new Vehicle(plateNumber);
        queue.add(vehicle);

    }

    /*
     * static void generateVehicle( ) { if ( queue.size() ==
     * Config.QUEUE_MAX_VEHICLES ) { return; }
     * 
     * String[] plateNumbers = { "RAZ", "JOHN", "LON" }; String[] vehicleTypes = {
     * "Car", "Van" };
     * 
     * String plateNumber = plateNumbers[ rng.nextInt( plateNumbers.length ) ] +
     * String.format( "%3d", rng.nextInt( 1000 ) );
     * 
     * String vehicleType = vehicleTypes[ rng.nextInt( vehicleTypes.length ) ];
     * 
     * int dirtinessLevel = rng.nextInt( Vehicle.MAX_CLEANLINESS_LEVEL );
     * 
     * Vehicle vehicle = null; switch ( vehicleType ) { case "Car":
     * 
     * vehicle = new Car( dirtinessLevel, plateNumber );
     * 
     * break; case "Van":
     * 
     * vehicle = new Van( dirtinessLevel, plateNumber );
     * 
     * break; }
     * 
     * queue.add( vehicle ); }
     */
    static void checkQueue(Pump gasStationMap[][]) {
        /* 
         * No changes are made if one of the following two criterias are met:
         * a. if all the pumps are busy (maximum possible vehicles are present at the pump)
         * b. if no vehicles are waiting to be fuelled in the queue
         */
        if (atPumpVehicles.size() == Config.FUEL_MAX_VEHICLES || queue.size() == 0) {
            return;
        }

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

        while (queue.size() > 0) {
            Vehicle vehicle = queue.get(0);
            queue.remove(0);

            tempEmptyPump.FuelVehicle(vehicle);

            // Loop is broken if all the pumps are busy (maximum possible vehicles are present at the pump)
            if (atPumpVehicles.size() == Config.FUEL_MAX_VEHICLES) {
                break;
            }
        }
    }

    /*
     * static binaryToInt( boolean pumpUsage) static void checkEmptyPump( ) { int
     * lane=0; do { int binaryCase = gasStation[lane][2]?1:0 + ( 10 *
     * gasStation[lane][1]?1:0 ) + ( 100 * gasStation[lane][0]?1:0 ); switch(
     * binaryCase ) { case 000: return [lane, 2]; lane=3; break; case 001: return
     * [lane, 1]; lane=3; break; case 011: case 010: return [lane, 1]; lane=3;
     * break; case 111: case 110: case 101: case 100: lane++; break; } } while(
     * lane<3 ); }
     */
    
}
