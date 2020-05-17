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
public class MoneyTest {
    
    public MoneyTest() {
    }

    /**
     * Test of setAmount method, of class Money.
     */
    @Test
    public void testSetAmount() {
        try {
            long amt = 1000;
            String currency = "Cash";
            Money inst = new Money(amt,currency);
            long newamt = 1500;
            inst.setAmount(newamt);
            assertEquals(newamt, inst.getAmount());
        } catch (Exception e) {
            fail("Amount did not store properly");
        }
    }

    /**
     * Test of setCurrency method, of class Money.
     */
    @Test
    public void testSetCurrency() {
        try {
            System.out.println("setCurrency");
            String currency = "Cash";
            Money instance = new Money();
            instance.setCurrency(currency);
            String expresult = "Cash";
            String result = instance.getCurrency();
            assertEquals(expresult,result);
        } catch (Exception e) {
            fail("Currency did not store properly.");
        }
    }
}
