/*
 * Immutable Customer object
 */
package com.mycompany.parkingsystem;

/**
 *
 * @author richardfallat
 */
public class Customer {
    
    private final String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private final String[] address;
    private final Address addressObj;
    
    /**
     * Immutable Customer object
     * @param c
     * @param firstName
     * @param lastName
     * @param phoneNumber
     * @param a
     * @throws Exception
     */
    public Customer(
            CustomerProfile c,
            String firstName,
            String lastName,
            String phoneNumber,
            Address a
            ) throws Exception {
        this.id = c.getID();
        
        // Ensure input entered
        if (firstName.length() >= 1) {
            this.firstName = firstName;
        } else {
            throw new Exception("Empty value: firstName");
        }
        // Ensure input entered
        if (lastName.length() >= 1) {
            this.lastName = lastName;
        } else {
            throw new Exception("Empty value: lastName");
        }
        if (phoneNumber.length() <= 14 && phoneNumber.length() >= 11) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new Exception("Phone numbers must contain 1 + area code");
        }
        this.address = a.getAddressInfo();
        this.addressObj = a;
    }
    
    /** Concatenate first and last name
     *
     * @return
     */
    public String getCustomerName() {
        String customerName = lastName + ", " + firstName;
        return customerName;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String[] getAddress() {
        return address;
    }
    
    public Address getAddressObj() {
        return addressObj;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", address=" + address + '}';
    }
    
}



