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
public class Car {
    
    private final CarType type;
    private final String licensePlate;
    private final Customer Owner; // dependency injection
    
    public Car(CarType type, String licensePlate, Customer Owner) {
        this.type = type;
        this.licensePlate = licensePlate;
        this.Owner = Owner; //replace with Customer params
    }
    
    public CarType getType() {
        return type;
    }
    
    public String getLicensePlate() {
        return this.licensePlate;
    }
    
    public Customer getOwner() {
        Customer tmp = new Customer();
        return tmp;
    }

    @Override
    public String toString() {
        return "Car{" + "type=" + type + ", licensePlate=" + licensePlate + ", Owner=" + Owner + '}';
    }
    
}
