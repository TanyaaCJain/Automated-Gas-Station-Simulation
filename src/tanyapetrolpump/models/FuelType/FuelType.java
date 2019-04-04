/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanyapetrolpump.models.FuelType;

/**
 *
 * @author Tanya Jain <https://tanya-jain.xyz>
 */
public class FuelType {
    private String type;

    public FuelType(String type) {
        this.setType(type);
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

    @Override
    public String toString() {
        return getType();
    }


}
