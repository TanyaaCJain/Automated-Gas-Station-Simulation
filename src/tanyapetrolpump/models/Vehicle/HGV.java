package tanyapetrolpump.models.Vehicle;

import tanyapetrolpump.models.FuelType.*;

/**
 *
 * @author Tanya Jain <https://tanya-jain.xyz>
 */
public class HGV extends Vehicle {
  //private String plateNumber;
  public HGV( String plateNumber )
  {
      super(plateNumber, 150);
      super.setType("HGV");
      // HGV can only run on Diesel
      Diesel vehicleFuelType = new Diesel();
      super.setVehicleFuelType(vehicleFuelType);
  }
}
