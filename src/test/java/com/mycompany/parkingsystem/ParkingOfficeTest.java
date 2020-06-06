/*
 * Test the ParkingOffice object
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
public class ParkingOfficeTest {
    
    public ParkingOfficeTest() {
    }
    
    /**
     * Test of register method, of class ParkingOffice.
     */
    @Test
    public void testRegisterCustomer() {
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
            Customer n = testCustomer(new CustomerProfile("2"));
            instance.register(n);
            int expResult = 4;
            int result = instance.getListOfCustomers().size();
            assertEquals(expResult,result);
        } catch (Exception e) {
            fail("Incorrect ArrayList size: Type Customer");
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
            ParkingLot l2 = testParkingLot(new CustomerProfile("1"));
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
    
    /**
     * Test of register method, with PermitManager parameter.
     */
    @Test
    public void testRegisterPermit() throws Exception {
        try {
            System.out.println("register(Car,Date):ParkingPermit");
            String id = "0019";
            Car c = testCar(CarType.COMPACT,"2LIVNDIEINLA");
            Car d = testCar(CarType.SUV,"STEELERS4LIFE");
            ParkingPermit a = testPermit(id,c.getType(),c.getLicensePlate());
            ParkingPermit b = testPermit(id,d.getType(),d.getLicensePlate());
            List<ParkingPermit> permits = new ArrayList();
            permits.add(a);
            permits.add(b);
            PermitManager pm = new PermitManager(permits);
            
            ParkingOffice po = testParkingOffice(new TransactionManager(),pm);
            
            Date exp = java.sql.Date.valueOf("2021-1-1");
            ParkingPermit e = po.register(c, exp);
            
            int expResult = 3;
            int result = pm.getPermits().size();
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail("Incorrect ArrayList size: Type ParkingPermit from ParkingManager class.");
        }
    }
    
    /** 
     * Tests proper permit array insertion
     */
    @Test
    public void testPermitArraySize() throws Exception {
        try {
            System.out.println("park");
            int amt = 10;
            TransactionManager tm = testTMPark(amt);
            ParkingOffice po = testParkingOffice(tm, new PermitManager());
            int expResult = 10;
            assertEquals(expResult, po.getTransactions().getTransactions().size());
        } catch (Exception e) {
            fail("Wong number of transactions.");
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
            ParkingOffice po = testParkingOffice(instance, new PermitManager());
            double result = po.getParkingCharges(testCustomer(new CustomerProfile("0"))).getAmount();
            double expResult = 90;
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail("getParkingCharges(Customer) not properly calculated");
        }
    }
    
     /** 
     * Contains transactions from SUV permits
     */
    @Test
    public void testParkingChargesPermitSUV() throws Exception {
        try {
            System.out.println("getParkingCharges(Permit):CarType.SUV");
            CarType ctest = CarType.SUV;
            TransactionManager instance = new TransactionManager(testTransArray());
            ParkingOffice po = testParkingOffice(instance, new PermitManager());
            double result = po.getParkingCharges(testPermit(ctest)).getAmount();
            double expResult = 50;
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail("getParkingCharges(Permit) not properly calcualated for CarType.SUV");
        }
    }
    
    /** 
     * Contains transactions from COMPACT permits
     */
    @Test
    public void testParkingChargesPermitCOMPACT() throws Exception {
        try {
            System.out.println("getParkingCharges(Permit):CarType.COMPACT");
            CarType ctest = CarType.COMPACT;
            TransactionManager instance = new TransactionManager(testTransArray());
            ParkingOffice po = testParkingOffice(instance, new PermitManager());
            double result = instance.getParkingCharges(testPermit(ctest)).getAmount();
            double expResult = 40;
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail("getParkingCharges(Permit) not properly calcualated for CarType.COMPACT");
        }
    }
    
    
    // Helper methods for testing purposes
    // Address object for testing purposes
    private  Address testAddress(CustomerProfile cp) throws Exception {
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
    private  Customer testCustomer(CustomerProfile cp) throws Exception {
        String first = "Jane";
        String last = "Doh";
        String phone = "555-555-1234";
        Address a = testAddress(cp);
        String id = a.getID();
        Customer newC = new Customer(cp,first,last,phone,a);
        return newC;
    }
    
    // ParkingLot object for testing purposes
    private  ParkingLot testParkingLot(CustomerProfile cp) throws Exception {
        String id = cp.getID();
        String name = "Joe's Parking";
        Address address = testAddress(cp);
        double maxCost = 20.00;
        return new ParkingLot(id,name,address,maxCost);
    }
    
    // Car object for testing purposes
    private  Car testCar(CarType ct,String plate) throws Exception {
        //String plate = "2LIVNDIEINLA";
        Car instance = new Car(ct,plate,testCustomer(new CustomerProfile("0")));
        return instance;
    }
    
    // ParkingPermit object for testing purposes
    private  ParkingPermit testPermit(String id,CarType ct,String plate) throws Exception{
        Date date = java.sql.Date.valueOf(("2021-1-1"));
        ParkingPermit instance = new ParkingPermit(id,testCar(ct,plate),date);
        return instance;
    }
    
    // ParkingOffice object for testing purposes
    private ParkingOffice testParkingOffice(TransactionManager tm,PermitManager pm) throws Exception {
            Customer c1 = testCustomer(new CustomerProfile("0"));
            Customer c2 = testCustomer(new CustomerProfile("1"));
            List<Customer> listOfCustomers = new ArrayList();
            listOfCustomers.add(c1);
            listOfCustomers.add(c1);
            listOfCustomers.add(c2);
            ParkingLot p1 = testParkingLot(new CustomerProfile("3"));
            ParkingLot p2 = testParkingLot(new CustomerProfile("4"));
            List<ParkingLot> listOfLots = new ArrayList();
            listOfLots.add(p1);
            listOfLots.add(p2);
            ParkingOffice instance = new ParkingOffice(
                    "Joe's Parking Office",
                    listOfCustomers,
                    listOfLots,
                    testAddress(new CustomerProfile("5")),
                    tm,
                    pm
            );
            return instance;
    }
    
    // TransactionManager helper methods
    // ParkingPermit object 2 for testing purposes
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
    
    // TransactionManager array adder method for testing purposes
    private TransactionManager testTMPark(int arraySize) throws Exception {
        TransactionManager instance = new TransactionManager();
        for (int i = 1; i <= arraySize; i++) {
            int id = i;
            Date date = java.sql.Date.valueOf("2020-5-" + Integer.toString(i));
            ParkingPermit permit = testPermit(CarType.COMPACT);
            ParkingLot parkingLot = testLot(10.00,id);
            ParkingTransaction park = instance.park(date, permit, parkingLot);
        }
        return instance;
    }
    
}
