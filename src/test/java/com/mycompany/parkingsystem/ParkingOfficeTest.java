/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parkingsystem;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author richardfallat
 */
public class ParkingOfficeTest {
    
    public ParkingOfficeTest() {
    }

    /**
     * Test of register method, of class ParkingOffice.
     */
    @Test
    public void testRegister() {
        try {
            System.out.println("setListOfCustomers");
            Customer c1 = new Customer();
            Customer c2 = new Customer();
            List<Customer> listOfCustomers = new ArrayList();
            listOfCustomers.add(c1);
            listOfCustomers.add(c1);
            listOfCustomers.add(c2);
            ParkingOffice instance = new ParkingOffice();
            instance.setListOfCustomers(listOfCustomers);
            System.out.println("register");
            Customer n = new Customer();
            instance.register(n);
            int expResult = 4;
            int result = instance.getListOfCustomers().size();
            assertEquals(expResult,result);
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setParkingOfficeName method, of class ParkingOffice.
     */
    @Test
    public void testSetParkingOfficeName() {
        try {
            System.out.println("setParkingOfficeName");
            String parkingOfficeName = "Joe's Parking";
            ParkingOffice instance = new ParkingOffice();
            instance.setParkingOfficeName(parkingOfficeName);
            String expresult = parkingOfficeName;
            String result = instance.getParkingOfficeName();
            assertEquals(expresult,result);
        } catch (Exception e) {
            fail("Parking office name not properly set");
        }
    }

    /**
     * Test of setListOfCustomers method, of class ParkingOffice.
     */
    @Test
    public void testSetListOfCustomersSize() {
        try {
            System.out.println("setListOfCustomers");
            Customer c1 = new Customer();
            Customer c2 = new Customer();
            List<Customer> listOfCustomers = new ArrayList();
            listOfCustomers.add(c1);
            listOfCustomers.add(c1);
            listOfCustomers.add(c2);
            ParkingOffice instance = new ParkingOffice();
            instance.setListOfCustomers(listOfCustomers);
            int expresult = 3;
            int result = instance.getListOfCustomers().size();
            assertEquals(expresult,result);
        } catch (Exception e) {
            fail("List<Customer> not proper size");
        }
    }

    /**
     * Test of setListOfParkingLots method, of class ParkingOffice.
     */
    @Test
    public void testSetListOfParkingLotsSize() {
        try {
            System.out.println("setListOfParkingLots");
            ParkingLot l1 = new ParkingLot();
            ParkingLot l2 = new ParkingLot();
            List<ParkingLot> listOfParkingLots = new ArrayList();
            listOfParkingLots.add(l1);
            listOfParkingLots.add(l2);
            listOfParkingLots.add(l2);
            listOfParkingLots.add(l2);
            ParkingOffice instance = new ParkingOffice();
            instance.setListOfParkingLots(listOfParkingLots);
            int expresult = 4;
            int result = instance.getListOfParkingLots().size();
            assertEquals(expresult,result);
        } catch (Exception e) {
            fail("List<ParkingLot> not proper size");
        }
    }
    
}
