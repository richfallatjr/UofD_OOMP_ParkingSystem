/*
 * Immutable Money object
 */
package com.mycompany.parkingsystem;

/**
 *
 * @author richardfallat
 */
public class Money {
    
    
    private final double amount;
    private final String currency;
    
    /** Immutable Money object
     *
     * @param amount
     * @param currency
     */
    public Money(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Money{" + "amount=" + amount + ", currency=" + currency + '}';
    }
    
}
