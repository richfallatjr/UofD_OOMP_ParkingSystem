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
public class Money {
    
    private long amount;
    private String currency;
    
    public Money() {
        this.amount = 1000;
        this.currency = "Credit";
    }
    
    public Money(long amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public long getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Money{" + "amount=" + amount + ", currency=" + currency + '}';
    }
    
}
