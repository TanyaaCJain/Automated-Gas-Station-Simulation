package tanyapetrolpump.GUI;

//import java.util.*; 
import java.util.ArrayList;

import tanyapetrolpump.Config;
import tanyapetrolpump.Data;
import tanyapetrolpump.Pump;
import tanyapetrolpump.TanyaPetrolPump;

public abstract class MainWindow
{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RED_BG = "\u001B[41m";
    public static final String ANSI_GREEN_BG = "\u001B[42m";
    public static void drawUI( )
    {
        clearScreen();
        drawQueue();
        System.out.println( "\n" );
        drawStation( TanyaPetrolPump.getGasStationMap() );
        drawGlobalInformation();
        System.out.println( "\n" );
        drawInServiceVehicles();
        System.out.println( "\n" );
        drawServicedVehicles();
        System.out.println( "\n" );
        drawTransactions();
    }

   
    private static void drawStation( Pump[][] stationToDraw ) 
    // function prints which pump is available in a defined diagram
    {
        int pumpIdToPrint = 0;
        int laneNumberToPrint = 0;
        System.out.println( "Station Pump availability: \n" );
        String laneAvailString = "";
        String pumpAvailString = "";
        for( int lane = 0; lane < 3; lane++ )
        {
            laneNumberToPrint = lane + 1;
            laneAvailString = "* Lane " + laneNumberToPrint + " ";
            for( int pump = 0; pump < 3; pump++, pumpIdToPrint++)
            {
                laneAvailString = laneAvailString + "*****";
                if( !stationToDraw[lane][pump].getPumpUsage() )
                    pumpAvailString = ANSI_GREEN_BG + ANSI_WHITE + " " + pumpIdToPrint + "  AVAIL " + ANSI_RESET;
                else
                    pumpAvailString = ANSI_RED_BG + ANSI_WHITE + " " + pumpIdToPrint + "  BUSY  " + ANSI_RESET; 
                laneAvailString = laneAvailString + pumpAvailString;
                laneAvailString = laneAvailString + "*****";
            }
            System.out.println( laneAvailString );
            laneAvailString = "*";
            for (int starcounter=0; starcounter < 68; starcounter++ )
                laneAvailString += "*";    
            System.out.println( laneAvailString );
            laneAvailString = "";
        }
    }
    
    private static void drawGlobalInformation() {
        
        String litresDispensedString1 = "* Total Litres Dispensed *****";
        litresDispensedString1 += ANSI_GREEN_BG + " Unleaded: " + Config.TOTAL_UNLEADED_LITRES_DISPENSED + "L " + ANSI_RESET + "****";
        litresDispensedString1 += ANSI_GREEN_BG + " Diesel: " + Config.TOTAL_DIESEL_LITRES_DISPENSED + "L " + ANSI_RESET + "****";
        litresDispensedString1 += ANSI_GREEN_BG + " LPG: " + Config.TOTAL_LPG_LITRES_DISPENSED + "L " + ANSI_RESET + "****";
        System.out.println("\n");  
        System.out.println(litresDispensedString1);
        System.out.println("\n");  
        //System.out.println( "Total Unleaded Litres Dispensed: " + Config.TOTAL_UNLEADED_LITRES_DISPENSED + "L");
        //System.out.println( "Total Diesel Litres Dispensed: " + Config.TOTAL_DIESEL_LITRES_DISPENSED + "L");
        //System.out.println( "Total LPG Litres Dispensed: " + Config.TOTAL_LPG_LITRES_DISPENSED + "L");
        System.out.println( "Amount of Money the Litres Dispensed Equate to: £" + Config.AMOUNT_EQUIVALENCE_TO_LITRES_DISPENSED );
        System.out.println( "Commission Earned by Employee: £" + Config.COMMISSION_EARNED_BY_EMPLOYEE );
        System.out.println( "Number of Vehicles Fuelled: " + Config.NUMBER_OF_VEHICLES_FUELLED );
        System.out.println( "Number of Vehicles Left Without Fuelling:" + Config.NUMBER_OF_VEHICLES_LEFT_WITHOUT_FUELLING );
    }

    public static void drawQueue() {
        System.out.println( "Queue:" );
        drawList( Data.queue, Config.QUEUE_MAX_VEHICLES );
    }

    private static void drawServicedVehicles() {
        System.out.println( "Fuelled Vehicles:" );
        drawList( Data.fuelledVehicles, Config.FUELLED_VEHICLES_MAX_DISPLAY );
    }
    
    private static void drawInServiceVehicles() {
        System.out.println( "At Pump Vehicles:" );
        drawList( Data.atPumpVehicles, Config.FUEL_MAX_VEHICLES );
    }
    
    private static void drawTransactions() {
        System.out.println( "Transactions:" );
        drawList( Data.transactions, Config.TRANSACTIONS_MAX_DISPLAY );
    }
    
    // this method will accept any kind of ArrayList
    // part of Generic Programming topic
    private static <T> void drawList( ArrayList<T> list, int maxDisplay )
    {
        // start at the end
        int startAt = list.size() - 1;
        int endAt = 0;
        
        // if there are more vehicles in the list than we need to display
        if ( list.size() > maxDisplay )
        {
            // modify end point
            endAt = startAt - maxDisplay;
        }
        
        // reverse order
        for ( int i = startAt; i > endAt; i-- )
        {
            System.out.println(
                    list.get( i ).toString()
            );
        }
    }
    
    private static void clearScreen( )
    {
        for ( int clear = 0; clear < 100; clear++ )
        {
            System.out.println( "\b" );
        }
    }
}