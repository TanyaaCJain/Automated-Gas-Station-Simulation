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
    
    //private int fuelLevel;
    private String plateNumber;
    private String type;
    private Timer makeVehicleWait;
    private FuelType vehicleFuelType;

  public Vehicle(String plateNumber) {
    // this.fuelLevel = fuelLevel;
    this.setPlateNumber(plateNumber);
    this.makeVehicleWait = new Timer(Config.VEHICLE_WAITING_TIME, e -> {
      if (Data.queue.contains(this))
        Data.queue.remove(this);
    });
    this.makeVehicleWait.setRepeats(false);
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

    /*
    public int getFuelLevel( )
    {
        return fuelLevel;
    }
    */
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

	
}


