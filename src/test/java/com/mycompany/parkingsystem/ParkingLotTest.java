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
public class ParkingLotTest {
    
    public ParkingLotTest() {
    }

    /**
     * Test of getDailyRate method, of class ParkingLot.
     */
    @Test
    public void testGetDailyRateCOMPACT() {
        try {
            System.out.println("getDailyRate");
            double amt = 10000;
            CarType ct = CarType.COMPACT;
            ParkingLot instance = new ParkingLot();
            instance.setMaxCost(amt);
            Money m = instance.getDailyRate(ct);
            double result = m.getAmount();
            double expresult = 8000;
            assertEquals(expresult, result);
        } catch (Exception e) {
            fail("getDailyRate returned unexpected results COMPACT");
        }
    }

    /**
     * Test of getDailyRate method, of class ParkingLot.
     */
    @Test
    public void testGetDailyRateSUV() {
        try {
            System.out.println("getDailyRate");
            double amt = 1000;
            CarType ct = CarType.SUV;
            ParkingLot instance = new ParkingLot();
            instance.setMaxCost(amt);
            Money m = instance.getDailyRate(ct);
            double result = m.getAmount();
            double expresult = amt;
            assertEquals(expresult, result);
        } catch (Exception e) {
            fail("getDailyRate returned unexpected results SUV");
        }
    }
    
}
