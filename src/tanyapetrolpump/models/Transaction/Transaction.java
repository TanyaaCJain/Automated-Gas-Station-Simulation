package tanyapetrolpump.models.Transaction;

import tanyapetrolpump.models.Vehicle.*;

public class Transaction
{
    private Vehicle vehicle;
    private double cost;
    private double litresDispensed;

    /**
     * @return the vehicle
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * @param vehicle the vehicle to set
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * @return the litresDispensed
     */
    public double getLitresDispensed() {
        return litresDispensed;
    }

    /**
     * @param litresDispensed the litresDispensed to set
     */
    public void setLitresDispensed(double litresDispensed) {
        this.litresDispensed = litresDispensed;
    }

    @Override
    public String toString()
    {
        return "Cost: £" + getCost() + " | " + getVehicle().getType() + " PN: " + 
               getVehicle().getPlateNumber() + " | Litres Dispensed: " + 
               getLitresDispensed() + "L";
    }

}
