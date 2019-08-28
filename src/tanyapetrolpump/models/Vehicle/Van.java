package tanyapetrolpump.models.Vehicle;

import tanyapetrolpump.models.FuelType.*;

/**
 *
 * @author Tanya Jain <https://tanya-jain.xyz>
 */
public class Van extends Vehicle {
  //private String plateNumber;
  public Van( String plateNumber, FuelType vehicleFuelType )
  {
      super(plateNumber, 80);
      super.setType("Van");
      super.setVehicleFuelType(vehicleFuelType);
  }
}
