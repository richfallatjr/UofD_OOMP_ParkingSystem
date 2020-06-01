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
public class CustomerProfile {
    
    // TODO remove of or create an is-a relationship
    private String id;
    
    public CustomerProfile() {
        id = "0";
    }
    
    public CustomerProfile(CustomerProfile c) {
        this.id = c.getID();
    }
    
    public CustomerProfile(String id) throws Exception {
        if (id.length() >= 1) {
            this.id = id;
        } else {
            throw new Exception("Empty value: id");
        }
    }
    
    public String getID() {
        return id;
    }

    @Override
    public String toString() {
        return "CustomerProfile{" + "id=" + id + '}';
    }
}
