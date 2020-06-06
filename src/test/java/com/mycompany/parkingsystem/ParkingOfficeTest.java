/*
 * Test the ParkingOffice object
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
    
    // Address object for testing purposes
    private static Address testAddress(CustomerProfile cp) throws Exception {
        //CustomerProfile id = new CustomerProfile("0");
        String s1 = "123 Atlantis Blvd.";
        String s2 = "";
        String city = "Wuhan";
        String state = "CA";
        String zip = "90210";
        Address a = new Address(cp,s1,s2,city,state,zip);
        return a;
    }

    // Custoemr object for testing purposes
    private static Customer testCustomer(CustomerProfile cp) throws Exception {
        String first = "Jane";
        String last = "Doh";
        String phone = "555-555-1234";
        Address a = testAddress(cp);
        String id = a.getID();
        Customer newC = new Customer(cp,first,last,phone,a);
        return newC;
    }
    
    // ParkingLot object for testing purposes
    private static ParkingLot testParkingLot(CustomerProfile cp) throws Exception {
        String id = cp.getID();
        String name = "Joe's Parking";
        Address address = testAddress(cp);
        double maxCost = 20.00;
        return new ParkingLot(id,name,address,maxCost);
    }
    
    /**
     * Test of register method, of class ParkingOffice.
     */
    @Test
    public void testRegister() {
        try {
            System.out.println("setListOfCustomers");
            Customer c1 = testCustomer(new CustomerProfile("0"));
            Customer c2 = testCustomer(new CustomerProfile("1"));
            List<Customer> listOfCustomers = new ArrayList();
            listOfCustomers.add(c1);
            listOfCustomers.add(c1);
            listOfCustomers.add(c2);
            ParkingOffice instance = new ParkingOffice();
            instance.setListOfCustomers(listOfCustomers);
            System.out.println("register");
            Customer n = testCustomer(new CustomerProfile("2"));;
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
            Customer c1 = testCustomer(new CustomerProfile("0"));
            Customer c2 = testCustomer(new CustomerProfile("1"));
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
            ParkingLot l1 = testParkingLot(new CustomerProfile("0"));
            ParkingLot l2 = testParkingLot(new CustomerProfile("1"));;
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
