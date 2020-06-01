/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parkingsystem;

import java.util.HashMap;

/**
 *
 * @author richardfallat
 */
public class ParkingLot {
    
    private final String id;
    private final String name;
    private final Address address;
    // TODO change to double
    private final double maxCost;
    
    public ParkingLot(
            String id,
            String name,
            Address address,
            double maxCost
    ) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.maxCost = maxCost;
    }
    
    /*
    * Get daily rate for CarType
    */
    public Money getDailyRate(CarType ct, String currency) {
        //Money m = new Money();
        //TODO calculate daily rate in class
        // remove showValue from CarType enum
        ct.setValue(maxCost);
        double value = 0;
        switch(ct) {
            case COMPACT:
                value = ct.showValue(ct);
                //m.setAmount(value);
                
                break;
            case SUV:
                value = ct.showValue(ct);
                //m.setAmount(value);
                break;
        }
        Money m = new Money(value,currency);
        return m;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public double getMaxCost() {
        return maxCost;
    }

    @Override
    public String toString() {
        return "ParkingLot{" + "id=" + id + ", name=" + name + ", address=" + address + ", maxCost=" + maxCost + '}';
    }
    
}
