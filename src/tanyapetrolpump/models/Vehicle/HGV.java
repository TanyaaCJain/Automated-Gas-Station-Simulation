package tanyapetrolpump.models.Vehicle;

import tanyapetrolpump.models.FuelType.*;

/**
 *
 * @author Tanya Jain <https://tanya-jain.xyz>
 */
public class HGV extends Vehicle {
  //private String plateNumber;
  public HGV( String plateNumber, FuelType vehicleFuelType )
  {
      super(plateNumber);
      super.setType("HGV");
      super.setVehicleFuelType(vehicleFuelType);
  }
}
