/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanyapetrolpump;

import javax.swing.*;
import tanyapetrolpump.GUI.*;
import tanyapetrolpump.Pump;
//import java.util.Timer;
/**
 *
 * @author Tanya Jain <https://tanya-jain.xyz>
 */
public class TanyaPetrolPump {

  /**
   * @param args the command line arguments
   */

  // Timers
  private static Timer vehicleAdditionTimer;
  private static Timer checkQueueTimer;
  private static Timer drawUITimer;

  //public static void vehicleArrives( Vehicle vehicleArrivedOnStation ) {
    //Lane temporaryLane = new Lane;
    //temporaryLane.sendToLane( vehicleArrivedOnStation );
  //}

  private static Pump[][] gasStationMap;
  
  //has to be done in constructor
  public TanyaPetrolPump(int numberOfLanes, int numberOfPumps){
      gasStationMap = new Pump[numberOfLanes][numberOfPumps];   
  }

  public static Pump[][] getGasStationMap() {
    return gasStationMap;
  }

  public void initGasStationMap(){
    for(int lane=0; lane < gasStationMap.length; lane++)
      for(int pump=0; pump < gasStationMap[0].length; pump++)
          gasStationMap[lane][pump] = new Pump();
  }
  public static void main(String[] args) {

    // The main variable of Gas Station to form the 3 lanes, each containing 3 pumps
    TanyaPetrolPump gasStation = new TanyaPetrolPump(3, 3);
    gasStation.initGasStationMap();

    // Creation of 3 lanes in the gas station
    //Lane stationlanes = new Lane[3];
    
    startQueue();
    startCheckQueue(gasStationMap);
    startDrawUI();
    
    JFrame frame = new JFrame();
    frame.setVisible( true );

  }

  private static void startQueue( )
  {
    vehicleAdditionTimer = new Timer( Config.VEHICLE_GENERATION_TIMER_DELAY, e -> Data.generateVehicle());
    vehicleAdditionTimer.start();
  }
  
  private static void startCheckQueue(Pump gasStationMap[][])
  {
      checkQueueTimer = new Timer( Config.CHECK_QUEUE_TIMER_DELAY, e -> Data.checkQueue(gasStationMap));
      checkQueueTimer.start();
  }
  
  private static void startDrawUI( )
  {
      drawUITimer = new Timer( Config.DRAWUI_TIMER_DELAY, e -> MainWindow.drawUI());
      drawUITimer.start();
  }
}