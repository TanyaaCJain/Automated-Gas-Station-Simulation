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
        drawGlobalInformation();
        System.out.println( "\n\n" );
        drawQueue();
        System.out.println( "\n\n" );
        drawStation( TanyaPetrolPump.getGasStationMap() );
        System.out.println( "\n\n" );
        drawInServiceVehicles();
        System.out.println( "\n\n" );
        drawServicedVehicles();
        System.out.println( "\n\n" );
        drawTransactions();
    }
    
/*
    private static void repeatString( String stringToRepeat, int timesToRepeat) {
        for(int counter=0; counter < timesToRepeat ; counter++) 
	        System.out.println( stringToRepeat );
    }*/
    

   
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
            //System.out.print( "* Lane " + lane+1 + " " ); //10 characters long
            laneNumberToPrint = lane + 1;
            laneAvailString = "* Lane " + laneNumberToPrint + " ";
            for( int pump = 0; pump < 3; pump++, pumpIdToPrint++)
            {
                //repeatString( "*", 5);
                laneAvailString = laneAvailString + "*****";
                //System.out.print( stationToDraw[lane][pump].getPumpUsage() );
                if( !stationToDraw[lane][pump].getPumpUsage() )
                    pumpAvailString = ANSI_GREEN_BG + ANSI_WHITE + " " + pumpIdToPrint + "  AVAIL " + ANSI_RESET;
                else
                    pumpAvailString = ANSI_RED_BG + ANSI_WHITE + " " + pumpIdToPrint + "  BUSY  " + ANSI_RESET; 
                //System.out.println( pumpAvailString ); //10 characters long
                laneAvailString = laneAvailString + pumpAvailString;
                laneAvailString = laneAvailString + "*****";
                
                //repeatString( "*", 5);
            }
            System.out.println( laneAvailString );
            laneAvailString = "*";
            //for (int spacecounter=0; spacecounter < 10; spacecounter++ )
            //    laneAvailString += " ";
            for (int starcounter=0; starcounter < 68; starcounter++ )
                laneAvailString += "*";    
            //String.join( laneAvailString, Collections.nCopies(10, " "));
            //String.join( laneAvailString, Collections.nCopies(60, "*"));
            System.out.println( laneAvailString );
            laneAvailString = "";
            //repeatString( " ", 10); 
            //repeatString( "*", 60);
            //System.out.print( '\n' );
        }
    }
    
    private static void drawGlobalInformation() {
        System.out.println( "Total Unleaded Litres Dispensed: " + Config.TOTAL_UNLEADED_LITRES_DISPENSED );
        System.out.println( "Total Diesel Litres Dispensed: " + Config.TOTAL_DIESEL_LITRES_DISPENSED );
        System.out.println( "Total LPG Litres Dispensed: " + Config.TOTAL_LPG_LITRES_DISPENSED );
        System.out.println( "Amount of Money the Litres Dispensed Equate to: £" + Config.AMOUNT_EQUIVALENCE_TO_LITRES_DISPENSED );
        System.out.println( "Commission Earned by Employee: £" + Config.COMMISSION_EARNED_BY_EMPLOYEE );
        System.out.println( "Number of Vehicles Fuelled: " + Config.NUMBER_OF_VEHICLES_FUELLED );
        //System.out.println( "Number of Vehicles Left Without Fuelling:" + Config.TOTAL_LITRES_DISPENSED );
    }

    private static void drawQueue() {
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


/*

import javax.swing.*;

public class MainWindow extends JFrame
{
    public MainWindow( )
    {
        JFrame frame = new JFrame();

        window.setSize( 600, 600 ); //paremeters::width,height
        window.setSize( new Dimension ( 600, 600 ));


        frame.setVisible( true );
        // make the window full screen
        //GUIToolkit.makeFrameFullScreen( this );
        
        // close the app once this window is closed
        //setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        // show this window
        //setVisible( true );
    }
}
*/