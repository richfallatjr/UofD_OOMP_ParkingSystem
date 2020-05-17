/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parkingsystem;

/**
 *
 * @author richardfallat
 */
public class Address extends CustomerProfile {
    private String id;
    private String streetAddress1;
    private String streetAddress2;
    private String city;
    private String state;
    private String zipcode;
    
    
    public Address() {
        this.id = "0";
        this.streetAddress1 = "123 Atlantis Blvd.";
        this.streetAddress2 = "";
        this.city = "Wuhan";
        this.state = "CA";
        this.zipcode = "90210";
    }
    
    // I'm not sure if this is necessary
    public Address(Address address) {
        this.id = address.getID();
        this.streetAddress1 = address.getStreetAddress1();
        this.streetAddress2 = address.getStreetAddress2();
        this.city = address.getCity();
        this.state = address.getState();
        this.zipcode = address.getZipcode();
    }
    
    public Address(
            CustomerProfile c,
            String streetAddress1,
            String streetAddress2,
            String city,
            String state,
            String zipcode
    ) throws Exception {
        super(c);
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
