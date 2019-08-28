package tanyapetrolpump.models.Vehicle;

import tanyapetrolpump.models.FuelType.*;

/**
 *
 * @author Tanya Jain <https://tanya-jain.xyz>
 */
public class Car extends Vehicle {
  //private String plateNumber;
  public Car( String plateNumber, FuelType vehicleFuelType )
  {
      super(plateNumber, 40);
      super.setType("Car");
      super.setVehicleFuelType(vehicleFuelType);
  }
}
