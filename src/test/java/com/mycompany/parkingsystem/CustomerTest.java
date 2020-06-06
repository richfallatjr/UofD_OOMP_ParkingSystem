/*
 * Test Customer object
 */
package com.mycompany.parkingsystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author richardfallat
 */
public class CustomerTest {
    
    public CustomerTest() {
    }
    
    /**
     * Validate firstName
     */
    @Test
    public void testEmptyFieldFirstNameExceptionPass() {
        try {
            String id = "9999999";
            String firstName = "";
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
            fail("An exception should have been caught");
        } catch (Exception f) {
            assertEquals(f.getMessage(), "Empty value: firstName");
        }
    }
    
    /**
     * Validate firstName
     */
    @Test
    public void testEmptyFieldFirstNameExceptionFail() {
        try {
            String id = "9999999";
            String firstName = "JoeSchmo";
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
            int result = firstName.length();
            int expresult = c.getFirstName().length();
            assertEquals(result,expresult);
        } catch (Exception f) {
            fail("An exception should not have been caught");
        }
    }
    
    /**
     * Validate lastName
     */
    @Test
    public void testEmptyFieldLastNameExceptionPass() {
        try {
            String id = "9999999";
            String firstName = "Joe";
            String lastName = "";
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
            fail("An exception should have been caught");
        } catch (Exception l) {
            assertEquals(l.getMessage(), "Empty value: lastName");
        }
    }
    
    /**
     * Validate lastName
     */
    @Test
    public void testEmptyFieldLastNameExceptionFail() {
        try {
            String id = "9999999";
            String firstName = "JoeSchmo";
            String lastName = "  Valens";
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
            int result = lastName.length();
            int expresult = c.getLastName().length();
            assertEquals(result,expresult);
        } catch (Exception l) {
            fail("An exception should not have been caught");
        }
    }
    
    /**
     * Validate PhoneNumber
     */
    @Test
    public void testEmptyFieldPhoneNumberExceptionPass() {
        try {
            String id = "9999999";
            String firstName = "Joe";
            String lastName = "Wu";
            String phoneNumber = "211(900)777-1234";
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
            fail("An exception should have been caught");
        } catch (Exception p) {
            assertEquals(p.getMessage(),
                    "Phone numbers must contain 1 + area code");
        }
    }
    
    /**
     * Validate PhoneNumber
     */
    @Test
    public void testEmptyFieldPhoneNumberExceptionFail() {
        try {
            String id = "9999999";
            String firstName = "JoeSchmo";
            String lastName = "  Valens";
            String phoneNumber = "19007771234";
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
            int result = phoneNumber.length();
            int expresult = c.getPhoneNumber().length();
            assertEquals(result,expresult);
        } catch (Exception p) {
            fail("An exception should not have been caught");
        }
    }
    
    /**
     * Validate customerName
     */
    @Test
    public void testGetCustomerName() {
        try {
            String id = "9999999";
            String firstName = "JoeSchmo";
            String lastName = "  Valens";
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
            String result = lastName + ", " + firstName;
            String expresult = c.getCustomerName();
            assertEquals(result,expresult);
        } catch (Exception cn) {
            fail("getCustomerName returned unexpected results");
        }
    }
    
    /**
     * Validate Address items
     */
    @Test
    public void testAddressItems() {
        try {
            int itemLength = 6;
            String id = "9999999";
            String firstName = "JoeSchmo";
            String lastName = "  Valens";
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
            int result = a.getAddressInfo().length;
            int expresult = itemLength;
            assertEquals(result,expresult);
        } catch (Exception ai) {
            fail("getAddressInfo returned unexpected array");
        }
    }
    
}
