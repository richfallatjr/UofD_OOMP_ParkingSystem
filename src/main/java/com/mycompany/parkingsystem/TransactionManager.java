/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parkingsystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** Extracts cost from given Customer or permit to create transaction
 *
 * @author richardfallat
 */
public class TransactionManager {
    
    private List<ParkingTransaction> transactions = new ArrayList();
    
    public TransactionManager(List<ParkingTransaction> pt) {
        this.transactions = pt;
    }
    
    public ParkingTransaction park(
            Date date,
            ParkingPermit permit,
            ParkingLot parkingLot
    ) {
        Money cost = getParkingCharges(permit);
        ParkingTransaction tmp = new ParkingTransaction(date,permit,parkingLot,cost.getCurrency());
        return tmp;
    }
    
    private Money getParkingCharges(ParkingPermit pp) {
        Car car = pp.getCar();
        CarType type = car.getType();
        double cost = type.showValue(type);
        // need to tie in park here
        return new Money(cost, "USD");
    }
    
    private Money getParkingCharges(Customer c) {
        // TODO get charge
        Money tmp = new Money(1000, "USD");
        return tmp;
    }
    
}
