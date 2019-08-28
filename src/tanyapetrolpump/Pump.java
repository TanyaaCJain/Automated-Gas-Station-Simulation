package tanyapetrolpump;

import javax.swing.Timer;

//import java.util.Random;
import java.util.concurrent.TimeUnit;

import tanyapetrolpump.models.FuelType.FuelType;
//import tanyapetrolpump.models.Price;
import tanyapetrolpump.models.Transaction.*;
import tanyapetrolpump.models.Vehicle.*;


public class Pump
{
    private boolean pumpUsage;

    public Pump() {
        this.pumpUsage = false;
    }
    
    public boolean getPumpUsage() {
        return pumpUsage;
    }

    public void setPumpUsage( boolean pumpUsage ) {
        this.pumpUsage = pumpUsage;
    }

    public void FuelVehicle( Vehicle vehicle )
    {
        Data.atPumpVehicles.add( vehicle );
        setPumpUsage(true);
        //int delay = fuelInLitresToRefill * Config.FUELLING_DURATION;
        //int delay = vehicle.getDirtinessLevel() * 300;
        //double litresDispensed = Config.FUELLING_DURATION * Config.DISPENSING_CAPABILITY;
        int litresDispensed = vehicle.getFuelTankCapacity() - vehicle.getFuelLevel();
        int fuellingDuration =  (int)(litresDispensed / Config.DISPENSING_CAPABILITY);
        Timer fuellingTimer = new Timer( fuellingDuration, e -> {
            Data.fuelledVehicles.add( vehicle );
            Data.atPumpVehicles.remove( vehicle );
            Config.NUMBER_OF_VEHICLES_FUELLED++;
            setPumpUsage(false);
            generateTransaction( vehicle , litresDispensed );
            int randomInt = Config.random_delay.nextInt(2000);
            try {
                TimeUnit.MILLISECONDS.sleep(randomInt);
            } catch (InterruptedException e_delay) {
                // Auto-generated catch block
                e_delay.printStackTrace();
            }
        } );
        fuellingTimer.setRepeats( false ); // one time timer
        fuellingTimer.start();
    }

    private static void generateTransaction( Vehicle vehicle, double litresDispensed )
    {
        Transaction transaction = new Transaction();
        
        // container for final transaction cost
        double cost = litresDispensed * Config.COST_OF_FUEL_PER_LITRE;
        // generate transaction
        /*
        switch ( vehicle.getClassName() )
        {
            case "Car":
                cost = Price.CAR.getPriceLevel();
                break;
            case "Van":
                cost = Price.VAN.getPriceLevel();
                break;
        }*/
             
        // final cost based on dirtiness level
        transaction.setCost( cost );
        transaction.setVehicle( vehicle );
        transaction.setLitresDispensed( litresDispensed );
        FuelType fuelType = vehicle.getVehicleFuelType();
        switch(fuelType.getType()) {
            case "Unleaded":
                Config.TOTAL_UNLEADED_LITRES_DISPENSED += litresDispensed;
                break;
            case "Diesel":
                Config.TOTAL_DIESEL_LITRES_DISPENSED += litresDispensed;
                break;
            case "LPG":
                Config.TOTAL_LPG_LITRES_DISPENSED += litresDispensed;
                break;
        }
        Config.AMOUNT_EQUIVALENCE_TO_LITRES_DISPENSED += cost;
        Config.COMMISSION_EARNED_BY_EMPLOYEE += 0.01 * litresDispensed;

        // add to list
        Data.transactions.add( transaction );
    }
}
