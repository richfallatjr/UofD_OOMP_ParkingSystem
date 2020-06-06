/*
 * ID tied to customer data
 */
package com.mycompany.parkingsystem;

/**
 *
 * @author richardfallat
 */
public class CustomerProfile {
    
    private String id;
    
    /**
     * Immutable CustomerProfile object
     * @param id
     * @throws Exception
     */
    public CustomerProfile(String id) throws Exception {
        if (id.length() >= 1) {
            this.id = id;
        } else {
            throw new Exception("Empty value: id");
        }
    }
    
    public String getID() {
        return id;
    }

    @Override
    public String toString() {
        return "CustomerProfile{" + "id=" + id + '}';
    }
}
