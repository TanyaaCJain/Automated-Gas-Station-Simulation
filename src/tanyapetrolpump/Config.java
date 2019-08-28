package tanyapetrolpump;

import java.util.Random;

public abstract class Config
{
    // Creation of vehicle in every 1.5 seconds or 1500 miliseconds
    public static final int VEHICLE_GENERATION_TIMER_DELAY = 1500;

    // Duration of the fuelling process is 8 seconds or 8000 miliseconds
    //public static final int FUELLING_DURATION = 8000;

    // Base duration for which a vehicle would wait before leaving the forecourt
    public static final int VEHICLE_WAITING_TIME = 1000;

    // Capability of a pump to dispense fuel is 1.5 Litres Per Second = 
    public static final double DISPENSING_CAPABILITY = 0.015;

    // The Current Cost of Fuel in Pounds per Litre
    public  static final double COST_OF_FUEL_PER_LITRE = 12.5;

    // Total amount of unleaded fuel dispensed at the gas station
    public static int TOTAL_UNLEADED_LITRES_DISPENSED = 0;

    // Total amount of diesel fuel dispensed at the gas station
    public static int TOTAL_DIESEL_LITRES_DISPENSED = 0;

    // Total amount of LPG fuel dispensed at the gas station
    public static int TOTAL_LPG_LITRES_DISPENSED = 0;

    // Amount in Pounds of the total cost of the fuel dispensed in the gas station
    public  static double AMOUNT_EQUIVALENCE_TO_LITRES_DISPENSED = 0;
    //AMOUNT_EQUIVALENCE_TO_LITRES_DISPENSED = TOTAL_LITRES_DISPENSED * COST_OF_FUEL_PER_LITRE

    // The 1% commission earned by the employees
    public  static float COMMISSION_EARNED_BY_EMPLOYEE = 0;

    // Number of vehicles serviced
    public static int NUMBER_OF_VEHICLES_FUELLED = 0;

    // Number of vehicles that left without getting fueled at the gas station
    public  static int NUMBER_OF_VEHICLES_LEFT_WITHOUT_FUELLING = 0;

    public static final int CHECK_QUEUE_TIMER_DELAY = 1500;
    public static final int DRAWUI_TIMER_DELAY = 1000;
    
    public static final int QUEUE_MAX_VEHICLES = 5;
    public static final int FUEL_MAX_VEHICLES = 9;
    
    public static final int FUELLED_VEHICLES_MAX_DISPLAY = 5;
    public static final int TRANSACTIONS_MAX_DISPLAY = 3;
    
    //Random
    public static final Random random_delay = new Random();
    
    public static int getVehicleCreationDelay() {
        return Config.VEHICLE_GENERATION_TIMER_DELAY + random_delay.nextInt( 700 );
    }
}
