/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanyapetrolpump.models.Vehicle;

import javax.swing.*;

import tanyapetrolpump.Config;
import tanyapetrolpump.Data;
import tanyapetrolpump.models.FuelType.*;

/**
 *
 * @author Tanya Jain <https://tanya-jain.xyz>
 */
public class Vehicle {
  //public static final int MAX_FUEL_LEVEL = 10;
    
    private int fuelLevel;
    private String plateNumber;
    private String type;
    private int vehicleWaitTime;
    private Timer makeVehicleWait;
    private FuelType vehicleFuelType;
    private int fuelTankCapacity;

  public Vehicle(String plateNumber, int fuelTankCapacity) {
    this.setFuelTankCapacity(fuelTankCapacity);
    this.setFuelLevel();
    this.setPlateNumber(plateNumber);
    this.setVehicleWaitTime();
    this.makeVehicleWait = new Timer(this.vehicleWaitTime, e -> {
      if (Data.queue.contains(this)) {
        Data.queue.remove(this);
        Config.NUMBER_OF_VEHICLES_LEFT_WITHOUT_FUELLING ++;
      }
    });
    this.makeVehicleWait.setRepeats(false);
    this.makeVehicleWait.start();
  }


  /**
   * @return the plateNumber
   */
    public String getPlateNumber() {
      return plateNumber;
    }

    /**
     * @param plateNumber the plateNumber to set
     */
    public void setPlateNumber(String plateNumber) {
      this.plateNumber = plateNumber;
    }
    /**
     * @return the type
     */
    public String getType() {
      return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
      this.type = type;
    }  
  
    /**
     * @return the vehicleFuelType
     */
    public FuelType getVehicleFuelType() {
      return vehicleFuelType;
    }

    /**
     * @param vehicleFuelType the vehicleFuelType to set
     */
    public void setVehicleFuelType(FuelType vehicleFuelType) {
      this.vehicleFuelType = vehicleFuelType;
    }

    /**
     * @return the fuelLevel
     */
    public int getFuelLevel( )
    {
        return fuelLevel;
    }
    /**
     * @param fuelLevel the fuelLevel to set
     */
    public void setFuelLevel() {
      this.fuelLevel = Config.random_delay.nextInt(this.fuelTankCapacity / 4);
    }
    
    @Override
    public String toString()
    {
        return "Type: " + getType() + " | PN: " + getPlateNumber() + " | Fuel: " + getVehicleFuelType().getType();
    }
    /*
    public String getClassName( )
    {
        // this will contain the package and class names together
        final String classAndPackageString = getClass().getName();
        
        // split up the string into an array of strings using a dot as delimiter
        final String[] classAndPackage = classAndPackageString.split( "\\." );
        
        // extract the class name, which will be last in the array
        final String className = classAndPackage[ classAndPackage.length - 1 ];
        
        // finally, return the result
        return className;
    }*/

  /**
   * @return the makeVehicleWait
   */
  public Timer getMakeVehicleWait() {
    return makeVehicleWait;
  }

  /**
   * @param makeVehicleWait the makeVehicleWait to set
   */
  public void setMakeVehicleWait(Timer makeVehicleWait) {
    this.makeVehicleWait = makeVehicleWait;
  }

  /**
   * @return the fuelTankCapacity
   */
  public int getFuelTankCapacity() {
    return fuelTankCapacity;
  }

  /**
   * @param fuelTankCapacity the fuelTankCapacity to set
   */
  public void setFuelTankCapacity(int fuelTankCapacity) {
    this.fuelTankCapacity = fuelTankCapacity;
  }

  /**
   * @param fuelLevel the fuelLevel to set
   */
  public void setFuelLevel(int fuelLevel) {
    this.fuelLevel = fuelLevel;
  }

  /**
   * @return the vehicleWaitTime
   */
  public int getVehicleWaitTime() {
    return vehicleWaitTime;
  }

  /**
   * @param vehicleWaitTime the vehicleWaitTime to set
   */
  public void setVehicleWaitTime() {
    this.vehicleWaitTime = Config.VEHICLE_WAITING_TIME + Config.random_delay.nextInt(1000);
  }

	
}


