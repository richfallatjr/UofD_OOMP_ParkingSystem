/*
 * Test ParkingTransaction object
 */
package com.mycompany.parkingsystem;

import java.sql.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author richardfallat
 */
public class ParkingTransactionTest {
    
    public ParkingTransactionTest() {
    }
    
    // Address object for testing purposes
    private Address testAddress(CustomerProfile cp) throws Exception {
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
    private Customer testCustomer(CustomerProfile cp) throws Exception {
        String first = "Jane";
        String last = "Doh";
        String phone = "555-555-1234";
        Address a = testAddress(cp);
        String id = a.getID();
        Customer newC = new Customer(cp,first,last,phone,a);
        return newC;
    }
    
    // Car object for testing purposes
    private Car testCar(CarType ct) throws Exception {
        String plate = "2LIVNDIEINLA";
        Car instance = new Car(ct,plate,testCustomer(new CustomerProfile("0")));
        return instance;
    }
    
    // ParkingPermit object for testing purposes
    private ParkingPermit testPermit(CarType ct) throws Exception{
        Date date = Date.valueOf(("2021-1-1"));
        String id = "2";
        ParkingPermit instance = new ParkingPermit(id,testCar(ct),date);
        return instance;
    }
    
    // ParkingLot object for testing purposes
    private ParkingLot testLot(double max) throws Exception {
        String id = "1000";
        String name = "Joe's Parking";
        Address address = testAddress(new CustomerProfile(id));
        ParkingLot instance = new ParkingLot(id,name,address,max);
        return instance;
    }
    
    /**
     * Test of getDailyRate method, of class ParkingLot.
     */
    @Test
    public void testGetDailyRateSUV() {
        try {
            System.out.println("getDailyRate");
            double maxCost = 100.00;
            ParkingLot lot = testLot(maxCost);
            CarType ct = CarType.SUV;
            ParkingPermit permit = testPermit(ct);
            Money m = lot.getDailyRate(ct,"USD");
            double result = m.getAmount();
            double expresult = 100.00;
            assertEquals(expresult, result);
        } catch (Exception e) {
            fail("getDailyRate returned unexpected results SUV");
        }
    }
    
    /**
     * Test of getDailyRate method, of class ParkingLot.
     */
    @Test
    public void testGetDailyRateCOMPACT() {
        try {
            System.out.println("getDailyRate");
            double maxCost = 100.00;
            ParkingLot lot = testLot(maxCost);
            CarType ct = CarType.COMPACT;
            ParkingPermit permit = testPermit(ct);
            Money m = lot.getDailyRate(ct,"USD");
            double result = m.getAmount();
            double expresult = 80.00;
            assertEquals(expresult, result);
        } catch (Exception e) {
            fail("getDailyRate returned unexpected results COMPACT");
        }
    }
    
    /**
     * Test of getDailyRate method, of class ParkingLot.
     */
    @Test
    public void testGetChargedAmountCOMPACT() {
        try {
            System.out.println("getChargedAmount");
            Date date = Date.valueOf(("2020-1-1"));
            double maxCost = 100.00;
            ParkingLot lot = testLot(maxCost);
            CarType ct = CarType.COMPACT;
            ParkingPermit permit = testPermit(ct);
            ParkingTransaction pt = new ParkingTransaction(date,permit,lot,"USD");
            double result = pt.getChargedAmount().getAmount();
            double expresult = new Money(80.00,"USD").getAmount();
            assertEquals(expresult, result);
        } catch (Exception e) {
            fail("getChargedAmount returned unexpected results COMPACT");
        }
    }
}
