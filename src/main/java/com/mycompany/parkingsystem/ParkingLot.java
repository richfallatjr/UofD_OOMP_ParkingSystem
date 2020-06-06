/*
 * Immutable ParkingLot object
 */
package com.mycompany.parkingsystem;

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
    
    /**
     * Immutable ParkingLot object
     * @param id
     * @param name
     * @param address
     * @param maxCost
     */
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
    
    /**
     * Get rate based on CarType discounts
     * @param ct
     * @param currency
     * @return
     */
    public Money getDailyRate(CarType ct, String currency) {
        ct.setValue(maxCost);
        double value = 0;
        switch(ct) {
            case COMPACT:
                value = ct.showValue(ct);
                
                break;
            case SUV:
                value = ct.showValue(ct);
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
