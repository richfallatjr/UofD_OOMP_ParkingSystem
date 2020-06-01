/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parkingsystem;

/**
 *
 * @author richardfallat
 */
public class Customer extends CustomerProfile {
    
    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String[] address;
    
    public Customer(
            CustomerProfile c,
            String firstName,
            String lastName,
            String phoneNumber,
            Address a
            ) throws Exception {
        super(c);
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
        // Load array from Address object
        this.address = a.getAddressInfo();
    }
    
    // concatanate customer name 
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

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", address=" + address + '}';
    }
    
}



