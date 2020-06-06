/*
 * Test Money object
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

    // Deprecate because class is immutable
    /**
     * Test of setAmount method, of class Money.
     */
    @Test
    public void testAmount() {
        try {
            String currency = "USD";
            double newamt = 15.00;
            Money inst = new Money(newamt,currency);
            assertEquals(newamt, inst.getAmount());
        } catch (Exception e) {
            fail("Amount did not store properly");
        }
    }

    // Deprecate because class is immutable
    /**
     * Test of setCurrency method, of class Money.
     */
    @Test
    public void testSetCurrency() {
        try {
            System.out.println("setCurrency");
            String currency = "USD";
            double amt = 10.00;
            Money instance = new Money(amt,currency);
            String expresult = "USD";
            String result = instance.getCurrency();
            assertEquals(expresult,result);
        } catch (Exception e) {
            fail("Currency did not store properly.");
        }
    }
}
