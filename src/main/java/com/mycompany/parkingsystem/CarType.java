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
    
    private long value;
    
    private void Cartype(long v) {
        value = v;
    }
    
    public long showValue(CarType ct) {
        long amount = 0;
        
        switch(ct) {
            case COMPACT:
                long discount = 80;
                BigDecimal d = new BigDecimal(discount*value).movePointLeft(2);
                amount = d.longValue();
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

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
