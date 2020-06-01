/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parkingsystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author richardfallat
 */
public class CustomerProfileTest {
    
    public CustomerProfileTest() {
    }
    
    /**
     * Validate id
     */
    @Test
    public void testEmptyFieldIDExceptionPass() {
        try {
            String id = "";
            CustomerProfile inst = new CustomerProfile(id);
            fail("An exception should have been caught");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Empty value: id");
        }
    }
    
    /**
     * Validate id
     */
    @Test
    public void testEmptyFieldIDExceptionFail() {
        try {
            String id = "99999";
            CustomerProfile inst = new CustomerProfile(id);
            int result = id.length();
            int expresult = inst.getID().length();
            assertEquals(result,expresult);
        } catch (Exception e) {
            fail("An exception should not have been caught");
        }
    }
    
    /**
     * Validate id propagation
     */
    @Test
    public void testCustomerIDSubclasses() {
        try {
            String id = "9999999";
            String firstName = "Richie";
            String lastName = "Valens";
            String phoneNumber = "1-900-777-1234";
            String street1 = "123 Burbank Blvd.";
            String street2 = "";
            String city = "Burbank";
            String state = "CA";
            String zipcode = "91604";
            CustomerProfile inst = new CustomerProfile(id);
            Address a = new Address(
                    inst,
                    street1,
                    street2,
                    city,
                    state,
                    zipcode
            );
            Customer c = new Customer(
                    inst,
                    firstName,
                    lastName,
                    phoneNumber,
                    a
            );
            assertEquals(inst.getID(), c.getID());
        } catch (Exception e) {
            fail("Subclass did not inherit: Customer id");
        }
    }
}
