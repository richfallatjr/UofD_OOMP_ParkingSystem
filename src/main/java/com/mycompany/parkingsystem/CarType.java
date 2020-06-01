/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parkingsystem;

import java.math.BigDecimal;

/**
 *
 * @author richardfallat
 */
public enum CarType {
    COMPACT,
    SUV;
    
    // TODO convert to double
    private double value;
    
    private void Cartype(double v) {
        value = v;
    }
    
    // TODO remove discount method
    public double showValue(CarType ct) {
        double amount = 0;
        
        switch(ct) {
            case COMPACT:
                double discount = 80;
                BigDecimal d = new BigDecimal(discount*value).movePointLeft(2);
                amount = d.doubleValue();
                break;
            case SUV:
                amount = value;
                break;
        }
        return amount;
    }

    public static CarType getCOMPACT() {
        return COMPACT;
    }

    public static CarType getSUV() {
        return SUV;
    }

    // TODO convert to double
    public double getValue() {
        return value;
    }

    // TODO convert to double
    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CarType{" + "value=" + value + '}';
    }
    
    
}
