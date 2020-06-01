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
public class CarTypeTest {
    
    public CarTypeTest() {
    }

    /**
     * Test of values method, of class CarType.
     */
    @Test
    public void testValuesSUV() {
        try {
            System.out.println("values");
            double value = 1000;
            CarType inst = null;
            inst = inst.valueOf("SUV");
            inst.setValue(value);
            double expresult = 1000;
            double result = inst.showValue(inst);
            assertEquals(expresult,result);
        } catch (Exception e) {
            fail("SUV returned wrong value");
        }
            
    }

    /**
     * Test of values method, of class CarType.
     */
    @Test
    public void testValuesCOMPACT() {
        try {
            System.out.println("values");
            double value = 1000;
            CarType inst = null;
            inst = inst.valueOf("COMPACT");
            inst.setValue(value);
            double expresult = 800;
            double result = inst.showValue(inst);
            assertEquals(expresult,result);
        } catch (Exception e) {
            fail("COMPACT returned wrong value");
        }
            
    }
    
}
