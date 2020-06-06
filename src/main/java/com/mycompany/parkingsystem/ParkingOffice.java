/*
 * Manage parking office data
 */
package com.mycompany.parkingsystem;

import java.util.Date;
import java.util.List;

/**
 *
 * @author richardfallat
 */
public class ParkingOffice {
    
    private String parkingOfficeName;
    private List<Customer> listOfCustomers;
    private List<ParkingLot> listOfParkingLots;
    private Address parkingOfficeAddress;
    private TransactionManager transactions = new TransactionManager();
    private PermitManager permits = new PermitManager();
    
    /** Empty ParkingOffice object
     *
     */
    public ParkingOffice() {}
    
    /** Initialize general ParkingOffice data
     *
     * @param parkingOfficeName
     * @param lc
     * @param lp
     * @param address
     */
    public ParkingOffice(
            String parkingOfficeName,
            List<Customer> lc,
            List<ParkingLot> lp,
            Address address
    ) {
        this.parkingOfficeName = parkingOfficeName;
        this.listOfCustomers = lc;
        this.listOfParkingLots = lp;
        this.parkingOfficeAddress = address;
    }
    
    /** Initialize ParkingOffice with TransactionManager and PermitManager data
     *
     * @param parkingOfficeName
     * @param lc
     * @param lp
     * @param address
     * @param transactions
     * @param permits
     */
    public ParkingOffice(
            String parkingOfficeName,
            List<Customer> lc,
            List<ParkingLot> lp,
            Address address,
            TransactionManager transactions,
            PermitManager permits
    ) {
        this.parkingOfficeName = parkingOfficeName;
        this.listOfCustomers = lc;
        this.listOfParkingLots = lp;
        this.parkingOfficeAddress = address;
        this.transactions = transactions;
        this.permits = permits;
    }
    
    public String getParkingOfficeName() {
        return this.parkingOfficeName;
    }
    
    /** Register a new Customer
     *
     * @param n
     */
    public void register(Customer n) {
        listOfCustomers.add(n);
    }
    
    /** Register a new ParkingPermit
     *
     * @param n
     * @param expr
     * @return
     */
    public ParkingPermit register(Car n, Date expr) {
        return permits.register(parkingOfficeName, n, expr);
    }
    
    /** Create a parking transaction
     *
     * @param d
     * @param pp
     * @param pl
     * @return
     */
    public ParkingTransaction park(Date d, ParkingPermit pp, ParkingLot pl) {
        return transactions.park(d, pp, pl);
    }
    
    /** Get total charges for a given permit
     *
     * @param pp
     * @return
     */
    public Money getParkingCharges(ParkingPermit pp) {
        return transactions.getParkingCharges(pp);
    }
    
    /** Get total parking charges for given customer
     *
     * @param c
     * @return
     */
    public Money getParkingCharges(Customer c) {
        return transactions.getParkingCharges(c);
    }

    public List<Customer> getListOfCustomers() {
        return listOfCustomers;
    }

    public List<ParkingLot> getListOfParkingLots() {
        return listOfParkingLots;
    }

    public Address getParkingOfficeAddress() {
        return parkingOfficeAddress;
    }

    public void setParkingOfficeName(String parkingOfficeName) {
        this.parkingOfficeName = parkingOfficeName;
    }

    public void setListOfCustomers(List<Customer> listOfCustomers) {
        this.listOfCustomers = listOfCustomers;
    }

    public void setListOfParkingLots(List<ParkingLot> listOfParkingLots) {
        this.listOfParkingLots = listOfParkingLots;
    }

    public void setParkingOfficeAddress(Address parkingOfficeAddress) {
        this.parkingOfficeAddress = parkingOfficeAddress;
    }
    
    public void setTransactions(TransactionManager tm) {
        this.transactions = tm;
    }
    
    public TransactionManager getTransactions() {
        return transactions;
    }
    
    public void setPermits(PermitManager pm) {
        this.permits = pm;
    }
    
    public PermitManager getPermits() {
        return permits;
    }

    @Override
    public String toString() {
        return "ParkingOffice{" + "parkingOfficeName=" + parkingOfficeName + ", listOfCustomers=" + listOfCustomers + ", listOfParkingLots=" + listOfParkingLots + ", parkingOfficeAddress=" + parkingOfficeAddress + ", transactions=" + transactions + ", permits=" + permits + '}';
    }
    
}
