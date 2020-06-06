/*
 * Test PermitManager object
 */
package com.mycompany.parkingsystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author richardfallat
 */
public class PermitManagerTest {
    
    public PermitManagerTest() {
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
    private static Car testCar(CarType ct,String plate) throws Exception {
        //String plate = "2LIVNDIEINLA";
        Car instance = new Car(ct,plate,testCustomer(new CustomerProfile("0")));
        return instance;
    }
    
    // ParkingPermit object for testing purposes
    private static ParkingPermit testPermit(String id,CarType ct,String plate) throws Exception{
        Date date = java.sql.Date.valueOf(("2021-1-1"));
        ParkingPermit instance = new ParkingPermit(id,testCar(ct,plate),date);
        return instance;
    }

    /**
     * Test of register method, of class PermitManager.
     */
    @Test
    public void testRegister() throws Exception {
        try {
            System.out.println("register");
            String id = "0019";
            Car c = testCar(CarType.COMPACT,"2LIVNDIEINLA");
            Car d = testCar(CarType.SUV,"STEELERS4LIFE");
            ParkingPermit a = testPermit(id,c.getType(),c.getLicensePlate());
            ParkingPermit b = testPermit(id,d.getType(),d.getLicensePlate());
            List<ParkingPermit> permits = new ArrayList();
            permits.add(a);
            permits.add(b);
            PermitManager instance = new PermitManager(permits);
            Date exp = java.sql.Date.valueOf("2021-1-1");
            ParkingPermit e = instance.register(id, c, exp);
            int expResult = 3;
            int result = instance.getPermits().size();
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail("Incorrect ArrayList size.");
        }
    }
    
}
