/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parkingsystem;

import java.util.Date;

/**
 *
 * @author richardfallat
 */
public class ParkingTransaction {
    
    private final Date date;
    private final ParkingPermit permit;
    private final ParkingLot parkingLot;
    private final Money money;
    
    public ParkingTransaction(
            Date date,
            ParkingPermit permit,
            ParkingLot parkingLot,
            Money money
    ) {
        this.date = date;
        this.permit = permit;
        this.parkingLot = parkingLot;
        this.money = money;
    }
    
    public Money getChargedAmount() {
        // TODO need to leverage car and get discount etc.
        return money;
    }
    
    public ParkingPermit getPermit() {
        return permit;
    }
    
    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    @Override
    public String toString() {
        return "ParkingTransaction{" + "date=" + date + ", permit=" + permit +
                ", parkingLot=" + parkingLot + ", money=" + money + '}';
    }
    
}
