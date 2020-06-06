/*
 * Create an Address object
 */
package com.mycompany.parkingsystem;

/**
 *
 * @author richardfallat
 */
public class Address {
    private final String id;
    private String streetAddress1;
    private final String streetAddress2;
    private String city;
    private String state;
    private String zipcode;
    
    /** Immutable Address object
     *
     * @param c
     * @param streetAddress1
     * @param streetAddress2
     * @param city
     * @param state
     * @param zipcode
     * @throws Exception
     */
    public Address(
            CustomerProfile c,
            String streetAddress1,
            String streetAddress2,
            String city,
            String state,
            String zipcode
    ) throws Exception {
        this.id = c.getID();
        // Ensure input entered
        if (streetAddress1.length() >= 1) {
            this.streetAddress1 = streetAddress1;
            System.out.println(streetAddress1.length());
        } else {
            throw new Exception("Empty value: streetAddress1");
        }
        
        this.streetAddress2 = streetAddress2;
        
        // Ensure input entered
        if (city.length() >= 1) {
            this.city = city;
        } else {
            throw new Exception("Empty value: city");
        }
        // Ensure input properly entered
        if (state.length() == 2) {
            this.state = state;
        } else {
            throw new Exception("States must contain two characters");
        }
        // Ensure input properly entered
        if (zipcode.length() == 5) {
            this.zipcode = zipcode;
        } else {
            throw new Exception("Zip code must contain six characters");
        }
        
    }
    
    /** Aggregate list of address information
     *
     * @return
     */
    public String[] getAddressInfo() {
        // array represents a temporary table row
        String[] addressInfo = {
            this.id,
            this.streetAddress1,
            this.streetAddress2,
            this.city,
            this.state,
            this.zipcode
        };
        return addressInfo;
    }

    public String getStreetAddress1() {
        return streetAddress1;
    }

    public String getStreetAddress2() {
        return streetAddress2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipcode() {
        return zipcode;
    }
    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", streetAddress1=" +
                streetAddress1 + ", streetAddress2=" + streetAddress2
                + ", city=" + city + ", state=" + state + ", zipcode="
                + zipcode + '}';
    }
    
    
}
