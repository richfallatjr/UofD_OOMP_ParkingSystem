/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    // Note: mutability allowed
    private List<ParkingPermit> permits = new ArrayList();
    
    public PermitManager() {
        
    }
    
    public PermitManager(List<ParkingPermit> permits) {
        this.permits = permits;
    }
    
    public ParkingPermit register(String id, Car c, Date expiration) {
        ParkingPermit newPermit;
        newPermit = new ParkingPermit(id,c,expiration);
        permits.add(newPermit);
        return newPermit;
    }
    
    public List<ParkingPermit> getPermits() {
        return this.permits;
    }
    
}
