/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parkingsystem;

import java.util.ArrayList;
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
    
    public ParkingOffice() {}
    
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
    
    public String getParkingOfficeName() {
        return this.parkingOfficeName;
    }
    
    public void register(Customer n) {
        listOfCustomers.add(n);
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
}
