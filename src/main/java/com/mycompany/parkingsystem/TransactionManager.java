/*
 * Manages Transaction lists
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
    
    /** TransactionManager object from ParkingTransaction list
     *
     * @param pt
     */
    public TransactionManager(List<ParkingTransaction> pt) {
        this.transactions = pt;
    }
    
    /** Create a parking transaction
     * 
     * @param date
     * @param permit
     * @param parkingLot
     * @return
     */
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
    
    /** Get total charges for a given permit
     * 
     * @param pp
     * @return
     */
    public Money getParkingCharges(ParkingPermit pp) {
        double amt = 0;
        String currency = null;
        for(int i = 0; i < transactions.size();i++) {
            if (Objects.equals(transactions.get(i).getPermit().getCar().getType(),pp.getCar().getType())) {
                amt = amt + transactions.get(i).getChargedAmount().getAmount();
                currency = transactions.get(i).getChargedAmount().getCurrency();
            }
        }
        return new Money(amt, currency);
    }
    
    /** Get total parking charges for given customer
     * 
     * @param c
     * @return
     */
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
