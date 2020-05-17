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
public class AddressTest {
    
    public AddressTest() {
    }
    
    /**
     * Validate StreetAddress1
     */
    @Test
    public void testEmptyFieldStreetAddress1ExceptionPass() {
        try {
            String id = "9999999";
            String firstName = "Joe";
            String lastName = "Lewis";
            String phoneNumber = "1-900-777-1234";
            String street1 = "";
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
            fail("An exception should have been caught");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Empty value: streetAddress1");
        }
    }
    
    /**
     * Validate StreetAddress1
     */
    @Test
    public void testEmptyFieldStreetAddress1ExceptionFail() {
        try {
            String id = "9999999";
            String firstName = "JoeSchmo";
            String lastName = "  Valens";
            String phoneNumber = "1-900-777-1234";
            String street1 = ".";
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
            int result = street1.length();
            int expresult = a.getStreetAddress1().length();
            assertEquals(result,expresult);
        } catch (Exception e) {
            fail("An exception should not have been caught");
        }
    }
    
    /**
     * Validate city
     */
    @Test
    public void testEmptyFieldCityExceptionPass() {
        try {
            String id = "9999999";
            String firstName = "Joe";
            String lastName = "Lewis";
            String phoneNumber = "1-900-777-1234";
            String street1 = "Dyson St";
            String street2 = "";
            String city = "";
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
            fail("An exception should have been caught");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Empty value: city");
        }
    }
    
    /**
     * Validate City
     */
    @Test
    public void testEmptyFieldCityExceptionFail() {
        try {
            String id = "9999999";
            String firstName = "JoeSchmo";
            String lastName = "  Valens";
            String phoneNumber = "1-900-777-1234";
            String street1 = ".";
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
            int result = city.length();
            int expresult = a.getCity().length();
            assertEquals(result,expresult);
        } catch (Exception e) {
            fail("An exception should not have been caught");
        }
    }
    
    /**
     * Validate state
     */
    @Test
    public void testFieldRulesStateExceptionPass() {
        try {
            String id = "9999999";
            String firstName = "Joe";
            String lastName = "Lewis";
            String phoneNumber = "1-900-777-1234";
            String street1 = "State";
            String street2 = "";
            String city = "Burbank";
            String state = "California";
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
            fail("An exception should have been caught");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "States must contain two characters");
        }
    }
    
    /**
     * Validate State
     */
    @Test
    public void testFieldRulesStateExceptionFail() {
        try {
            String id = "9999999";
            String firstName = "JoeSchmo";
            String lastName = "  Valens";
            String phoneNumber = "1-900-777-1234";
            String street1 = ".";
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
            int result = state.length();
            int expresult = a.getState().length();
            assertEquals(result,expresult);
        } catch (Exception e) {
            fail("An exception should not have been caught");
        }
    }
    
    /**
     * Validate zipcode
     */
    @Test
    public void testFieldRulesZipcodeExceptionPass() {
        try {
            String id = "9999999";
            String firstName = "Joe";
            String lastName = "Lewis";
            String phoneNumber = "1-900-777-1234";
            String street1 = "State";
            String street2 = "";
            String city = "Burbank";
            String state = "CA";
            String zipcode = "";
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
            fail("An exception should have been caught");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Zip code must contain six characters");
        }
    }
    
    /**
     * Validate zipcode
     */
    @Test
    public void testFieldRulesZipcodeExceptionFail() {
        try {
            String id = "9999999";
            String firstName = "JoeSchmo";
            String lastName = "  Valens";
            String phoneNumber = "1-900-777-1234";
            String street1 = ".";
            String street2 = "";
            String city = "Burbank";
            String state = "CA";
            String zipcode = "dk8H2";
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
            int result = zipcode.length();
            int expresult = a.getZipcode().length();
            assertEquals(result,expresult);
        } catch (Exception e) {
            fail("An exception should not have been caught");
        }
    }
    
    /**
     * Validate addressInfo
     */
    @Test
    public void testAddressInfoContentPass() {
        try {
            String id = "9999999";
            String firstName = "JoeSchmo";
            String lastName = "  Valens";
            String phoneNumber = "1-900-777-1234";
            String street1 = ".";
            String street2 = "";
            String city = "Burbank";
            String state = "CA";
            String zipcode = "dk8H2";
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
            String[] resultArray = a.getAddressInfo();
            boolean result = true;
            String[] exprArray = {id, street1, street2, city, state, zipcode};
            boolean expresult = false;
            int n = 0;
            for (String i: exprArray) {
                if (i.equals(resultArray[n])) {
                    expresult = true;
                    n ++;
                } else {
                    break;
                }
            }
            assertEquals(result,expresult);
        } catch (Exception e) {
            fail("An exception should not have been caught");
        }
    }/**
     * Validate addressInfo
     */
    @Test
    public void testAddressInfoContentFail() {
        try {
            String id = "9999999";
            String firstName = "JoeSchmo";
            String lastName = "  Valens";
            String phoneNumber = "1-900-777-1234";
            String street1 = ".";
            String street2 = "";
            String city = "Burbank";
            String state = "CA";
            String zipcode = "dk8H2";
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
            String[] resultArray = a.getAddressInfo();
            boolean result = true;
            String[] exprArray = {"foo", street1, street2, city, state, zipcode};
            boolean expresult = true;
            int n = 0;
            // compare strings for each array index
            for (String i: exprArray) {
                if (i.equals(resultArray[n])) {
                    expresult = true;
                    n ++;
                } else {
                    expresult = false;
                    break;
                }
            }
            assertNotEquals(result,expresult);
        } catch (Exception e) {
            fail("An exception should not have been caught");
        }
    }
    
    
}
