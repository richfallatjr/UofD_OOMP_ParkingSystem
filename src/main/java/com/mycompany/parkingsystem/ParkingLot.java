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
    
    private String id;
    private String name;
    private Address address;
    private long maxCost;
    
    public ParkingLot() {
        this.id = "0";
        this.name = "John Doe";
        this.address = new Address();
        this.maxCost = 2000;
    }
    
    public ParkingLot(String id,String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    
    /*
    * Get daily rate for CarType
    */
    public Money getDailyRate(CarType ct) {
        Money m = new Money();
        ct.setValue(maxCost);
        long value = 0;
        switch(ct) {
            case COMPACT:
                value = ct.showValue(ct);
                m.setAmount(value);
                break;
            case SUV:
                value = ct.showValue(ct);
                m.setAmount(value);
                break;
        }
        return m;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public long getMaxCost() {
        return maxCost;
    }

    public void setMaxCost(long maxCost) {
        this.maxCost = maxCost;
    }
    
}
