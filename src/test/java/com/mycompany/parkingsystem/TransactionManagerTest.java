/*
 * Test TransactionManager object
 */
package com.mycompany.parkingsystem;

import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author richardfallat
 */
public class TransactionManagerTest {
    
    public TransactionManagerTest() {
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
    private Car testCar(CarType ct, String plate) throws Exception {
        Car instance = new Car(ct,plate,testCustomer(new CustomerProfile("0")));
        return instance;
    }
    
    // ParkingPermit object for testing purposes
    private ParkingPermit testPermit(CarType ct) throws Exception{
        java.sql.Date date = java.sql.Date.valueOf(("2021-1-1"));
        String id = null;
        String plate = null;
        switch(ct) {
            case COMPACT:
                id = "1";
                plate = "2LIVNDIEINLA";
            case SUV:
                id = "2";
                plate = "STEELERS4LIFE";
        }
        ParkingPermit instance = new ParkingPermit(id,testCar(ct,plate),date);
        return instance;
    }
    
    // ParkingLot object for testing purposes
    private ParkingLot testLot(double max, int id) throws Exception {
        String idS = Integer.toString(id);
        String name = "Joe's Parking";
        Address address = testAddress(new CustomerProfile(idS));
        ParkingLot instance = new ParkingLot(idS,name,address,max);
        return instance;
    }
    
    // ParkingTransaction ArrayList for testing purposes
    private List<ParkingTransaction> testTransArray() throws Exception {
        int perm1 = 5;
        int perm2 = 5;
        TransactionManager tm = new TransactionManager();
        for(int i=0;i<perm1;i++){
            Date date = java.sql.Date.valueOf("2020-5-" + Integer.toString(i+1));
            ParkingLot lot = testLot(10.00,i);
            ParkingPermit permSUV = testPermit(CarType.SUV);
            ParkingTransaction pSUV = tm.park(date, permSUV, lot);
        }
        for(int i=0;i<perm2;i++){
            Date date = java.sql.Date.valueOf("2020-5-" + Integer.toString(i+1+perm1));
            ParkingLot lot = testLot(10.00,i);
            ParkingPermit permCOMPACT = testPermit(CarType.COMPACT);
            ParkingTransaction pCOMPACT = tm.park(date, permCOMPACT, lot);
        }
        return tm.getTransactions();
    }

    /**
     * Test park method from class TransactionManager.
     */
    @Test
    public void testPark() throws Exception {
        try {
            System.out.println("park");
            int id = 0;
            Date date = java.sql.Date.valueOf("2020-5-31");
            ParkingPermit permit = testPermit(CarType.COMPACT);
            ParkingLot parkingLot = testLot(150.00,id);
            TransactionManager instance = new TransactionManager();
            ParkingTransaction park = instance.park(date, permit, parkingLot);
            int result = instance.getTransactions().size();
            int expResult = 1;
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail("Park did not append transaction.");
        }
    }
    
    /** 
     * Tests proper permit array insertion
     */
    @Test
    public void testPermitArraySize() throws Exception {
        try {
            System.out.println("park");
            TransactionManager instance = new TransactionManager(testTransArray());
            int result = instance.getTransactions().size();
            int expResult = 10;
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail("getTransactions should contain 10 objects. Wrong size.");
        }
    }
    
    /** 
     * Tests getParkingCharges with Customer input
     */
    @Test
    public void testParkingChargesCustomer() throws Exception {
        try {
            System.out.println("getParkingCharges(Customer)");
            TransactionManager instance = new TransactionManager(testTransArray());
            double result = instance.getParkingCharges(testCustomer(new CustomerProfile("0"))).getAmount();
            double expResult = 90;
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail("getParkingCharges not properly calcualted for customer");
        }
    }
    
     /** 
     * Contains transactions from SUV permits
     */
    @Test
    public void testParkingChargesPermitSUV() throws Exception {
        try {
            System.out.println("park");
            CarType ctest = CarType.SUV;
            TransactionManager instance = new TransactionManager(testTransArray());
            double result = instance.getParkingCharges(testPermit(ctest)).getAmount();
            double expResult = 50;
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail("getParkingCharges not properly calcualated for CarType.SUV");
        }
    }
    
    /** 
     * Contains transactions from one permit
     */
    @Test
    public void testParkingChargesPermitCOMPACT() throws Exception {
        try {
            System.out.println("park");
            CarType ctest = CarType.COMPACT;
            TransactionManager instance = new TransactionManager(testTransArray());
            double result = instance.getParkingCharges(testPermit(ctest)).getAmount();
            double expResult = 40;
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail("getParkingCharges not properly calcualated for CarType.COMPACT");
        }
    }
}
