/*
 * Manage ParkingPermit lists
 */
package com.mycompany.parkingsystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author richardfallat
 */
public class PermitManager {
    private List<ParkingPermit> permits = new ArrayList();
    
    /** Create empty ParkingPermit list
     *
     */
    public PermitManager() {
        
    }
    
    /** Create PermitManager with provided ParkingPermit list
     *
     * @param permits
     */
    public PermitManager(List<ParkingPermit> permits) {
        this.permits = permits;
    }
    
    /** Register a new ParkingPermit
     *
     * @param id
     * @param c
     * @param expiration
     * @return
     */
    public ParkingPermit register(String id, Car c, Date expiration) {
        ParkingPermit newPermit;
        newPermit = new ParkingPermit(id,c,expiration);
        permits.add(newPermit);
        return newPermit;
    }
    
    public List<ParkingPermit> getPermits() {
        return this.permits;
    }
    
    public void setPermits(List<ParkingPermit> pp) {
        this.permits = pp;
    }

    @Override
    public String toString() {
        return "PermitManager{" + "permits=" + permits + '}';
    }
    
}
