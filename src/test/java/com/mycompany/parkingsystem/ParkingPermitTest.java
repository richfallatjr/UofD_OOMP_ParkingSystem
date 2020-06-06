/*
 * Test ParkingPermit object
 */
package com.mycompany.parkingsystem;

import java.sql.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author richardfallat
 */
public class ParkingPermitTest {
    
    public ParkingPermitTest() {
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
    
    // Car object for testing purposes
    private static Car testCar(CustomerProfile cp) throws Exception {
        String plate = "2LIVNDIEINLA";
        CarType ct = CarType.COMPACT;
        Car instance = new Car(ct,plate,testCustomer(new CustomerProfile("0")));
        return instance;
    }
    
    /** Verify CarType attribute
     * Test of getType method, of class Car.
     */
    @Test
    public void testGetOwner() throws Exception {
        System.out.println("getOwner");
        Date date = Date.valueOf(("2021-1-1"));
        String id = "2";
        ParkingPermit instance = new ParkingPermit(id,testCar(new CustomerProfile("0")),date);
        try {
            String expResult = "0";
            String result = instance.getCar().getOwner().getID();
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail("Incorrect ID");
        }
        try {
            String[] expResultA = testCustomer(new CustomerProfile("0")).getAddress();
            String[] resultA = instance.getCar().getOwner().getAddress();
            assertArrayEquals(expResultA, resultA);
        } catch (Exception e) {
            fail("Addresses do not match");
        }
    }
    
}
