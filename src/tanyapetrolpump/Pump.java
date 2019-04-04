package tanyapetrolpump;

import javax.swing.Timer;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import tanyapetrolpump.models.FuelType.FuelType;
//import tanyapetrolpump.models.Price;
import tanyapetrolpump.models.Transaction.*;
import tanyapetrolpump.models.Vehicle.*;


public class Pump
{
    /*
    private static int laneId = 0;
    private static int pumpId = 0;
    int laneNumber;
    int pumpNumber;
    //int pumpNumber[] = new int[2];
    */
    private static final Random random_delay = new Random();

    boolean pumpUsage;

    public Pump() {
        /*
        if(pumpId % 2 == 0 && pumpId > 0) 
        {
            this.laneNumber = ++laneId;
            this.pumpNumber = 0;
        }
        else 
        {
            this.laneNumber = laneId;
            this.pumpNumber = pumpId++;
        }
        */
        this.pumpUsage = false;
    }
    /**
	 * @return the laneNumber
	 */
	//public int getLaneNumber() {
	//	return laneNumber;
	//}

    /**
     * @param laneNumber the laneNumber to set
     */
    //public void setLaneNumber(int laneNumber) {
    //    this.laneNumber = laneNumber;
    //}

    /**
     * @return the pumpNumber
     */
    //public int getPumpNumber() {
    //    return pumpNumber;
    //}

    /**
     * @param pumpNumber the pumpNumber to set
     */
    //public void setPumpNumber(int pumpNumber) {
    //    this.pumpNumber = pumpNumber;
    //}
    public boolean getPumpUsage() {
        return pumpUsage;
    }

    public void setPumpUsage( boolean pumpUsage ) {
        this.pumpUsage = pumpUsage;
    }

    //public String toString( )
    //{
    //    return getLaneNumber() + getPumpNumber() + " " + getPumpUsage();
    //}

    public void FuelVehicle( Vehicle vehicle )
    {
        Data.atPumpVehicles.add( vehicle );
        setPumpUsage(true);
        //int fuelInTank = vehicle.getFuelLevel();
        //int fuelTankCapacity = vehicle.getFuelTankCapacity();
        //int fuelInLitresToRefill = fuelTankCapacity - fuelInTank;
        //int delay = fuelInLitresToRefill * Config.FUELLING_DURATION;

        //int delay = vehicle.getDirtinessLevel() * 300;
        
        double litresDispensed = Config.FUELLING_DURATION * Config.DISPENSING_CAPABILITY;

        Timer timer = new Timer( Config.FUELLING_DURATION, e -> {
            Data.fuelledVehicles.add( vehicle );
            Data.atPumpVehicles.remove( vehicle );
            Config.NUMBER_OF_VEHICLES_FUELLED++;
            setPumpUsage(false);
            generateTransaction( vehicle , litresDispensed );
            int randomInt = random_delay.nextInt(2000);
            try {
                TimeUnit.MILLISECONDS.sleep(randomInt);
            } catch (InterruptedException e_delay) {
                // Auto-generated catch block
                e_delay.printStackTrace();
            }
        } );
        timer.setRepeats( false ); // one time timer
        timer.start();
    }

    private static void generateTransaction( Vehicle vehicle, double litresDispensed )
    {
        Transaction transaction = new Transaction();
        
        // container for final transaction cost
        double cost = 0;
        
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
        
        //cost *= vehicle.getDirtinessLevel();
        cost = litresDispensed * Config.COST_OF_FUEL_PER_LITRE;

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
