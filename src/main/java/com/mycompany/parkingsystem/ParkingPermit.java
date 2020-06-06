/*
 * Create a ParkingPermit object
 */
package com.mycompany.parkingsystem;

import java.util.Date;

/**
 *
 * @author richardfallat
 */
public class ParkingPermit {
    
    private final String id;
    private final Car car;
    private final Date expiration;
    
    /** Create ParkingPermit object
     *
     * @param id
     * @param car
     * @param expiration
     */
    public ParkingPermit(String id, Car car, Date expiration) {
        this.id = id;
        this.car = car;
        this.expiration = expiration;
    }
    
    public Car getCar() {
        return this.car;
    }
    
    public String getID() {
        return this.id;
    }
    
    public Date getExpiration() {
        return this.expiration;
    }

    @Override
    public String toString() {
        return "ParkingPermit{" + "id=" + id + ", car=" + car + ", expiration=" + expiration + '}';
    }
    
}
