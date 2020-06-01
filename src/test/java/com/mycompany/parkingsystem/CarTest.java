/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parkingsystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author richardfallat
 */
public class CarTest {
    
    public CarTest() {
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

    /** Verify CarType attribute
     * Test of getType method, of class Car.
     */
    @Test
    public void testGetType() throws Exception {
        try {
            System.out.println("getType");
            String plate = "2LIVNDIEINLA";
            CarType ct = CarType.COMPACT;
            Car instance = new Car(ct,plate,testCustomer(new CustomerProfile("0")));
            CarType expResult = CarType.COMPACT;
            CarType result = instance.getType();
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail("Incorrect CarType: COMPACT");
        }
    }
    
    /** Verify CarType attribute
     * Test of getType method, of class Car.
     */
    @Test
    public void testGetOwner() throws Exception {
        
        System.out.println("getOwner");
        String plate = "2LIVNDIEINLA";
        CarType ct = CarType.COMPACT;
        Car instance = new Car(ct,plate,testCustomer(new CustomerProfile("0")));
        try {
            String expResult = "0";
            String result = instance.getOwner().getID();
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail("Incorrect CarType: COMPACT");
        }
        try {
            String[] expResultA = testCustomer(new CustomerProfile("0")).getAddress();
            String[] resultA = instance.getOwner().getAddress();
            assertArrayEquals(expResultA, resultA);
        } catch (Exception e) {
            fail("Addresses do not match");
        }
    }
    
}
