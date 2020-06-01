/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parkingsystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/** Extracts cost from given Customer or permit to create transaction
 *
 * @author richardfallat
 */
public class TransactionManager {
    
    private List<ParkingTransaction> transactions = new ArrayList();
    
    public TransactionManager() {
        
    }
    
    public TransactionManager(List<ParkingTransaction> pt) {
        this.transactions = pt;
    }
    
    public ParkingTransaction park(
            Date date,
            ParkingPermit permit,
            ParkingLot parkingLot
    ) {
        Money cost = getParkingCharges(permit);
        ParkingTransaction pt = new ParkingTransaction(date,permit,parkingLot,cost.getCurrency());
        transactions.add(pt);
        return pt;
    }
    
    public Money getParkingCharges(ParkingPermit pp) {
        double amt = 0;
        String currency = null;
        for(int i = 0; i < transactions.size();i++) {
            if (Objects.equals(transactions.get(i).getPermit().getID(),pp.getID())) {
                amt = amt + transactions.get(i).getChargedAmount().getAmount();
                currency = transactions.get(i).getChargedAmount().getCurrency();
            }
        }
        return new Money(amt, currency);
    }
    
    public Money getParkingCharges(Customer c) {
        double amt = 0;
        String currency = null;
        for(int i = 0; i < transactions.size();i++) {
            amt = amt + transactions.get(i).getChargedAmount().getAmount();
            currency = transactions.get(i).getChargedAmount().getCurrency();
        }
        return new Money(amt, currency);
    }
    
    public List<ParkingTransaction> getTransactions() {
        return transactions;
    }
    
}
