/*
 * Specify COMPACT or SUV to apply lot discounts
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
    
    private double value;
    
    private void Cartype(double v) {
        value = v;
    }
    
    /** Return applied discount
     *
     * @param ct
     * @return
     */
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
