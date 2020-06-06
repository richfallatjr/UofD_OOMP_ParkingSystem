/*
 * Test ParkingLot object
 */
package com.mycompany.parkingsystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author richardfallat
 */
public class ParkingLotTest {
    
    public ParkingLotTest() {
    }
    
    private static Address testAddress() throws Exception {
        CustomerProfile id = new CustomerProfile("0");
        String s1 = "123 Atlantis Blvd.";
        String s2 = "";
        String city = "Wuhan";
        String state = "CA";
        String zip = "90210";
        Address a = new Address(id,s1,s2,city,state,zip);
        return a;
    }

    /**
     * Test of getDailyRate method, of class ParkingLot.
     */
    @Test
    public void testGetDailyRateCOMPACT() {
        try {
            System.out.println("getDailyRate");
            double amt = 10.00;
            CarType ct = CarType.COMPACT;
            String id = "0";
            String name = "Joe's Parking";
            Address address = testAddress();
            double maxCost = 10.00;
            ParkingLot instance = new ParkingLot(id,name,address,maxCost);
            Money m = instance.getDailyRate(ct,"USD");
            double result = m.getAmount();
            double expresult = 8.00;
            assertEquals(expresult, result);
        } catch (Exception e) {
            fail("getDailyRate returned unexpected results COMPACT");
        }
    }

    /**
     * Test of getDailyRate method, of class ParkingLot.
     */
    @Test
    public void testGetDailyRateSUV() {
        try {
            System.out.println("getDailyRate");
            double amt = 10.00;
            CarType ct = CarType.SUV;
            String id = "0";
            String name = "Joe's Parking";
            Address address = testAddress();
            double maxCost = 10.00;
            ParkingLot instance = new ParkingLot(id,name,address,maxCost);
            Money m = instance.getDailyRate(ct,"USD");
            double result = m.getAmount();
            double expresult = amt;
            assertEquals(expresult, result);
        } catch (Exception e) {
            fail("getDailyRate returned unexpected results SUV");
        }
    }
    
}
