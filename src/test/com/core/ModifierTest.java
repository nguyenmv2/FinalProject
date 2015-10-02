package com.core;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hoangocdam on 9/28/15.
 */
public class ModifierTest {
    Modifier m;
    @Before
    public void setupTest(){
        Modifier m = new Modifier();
    }
    @Test
    public void initialTest(){
        m = new Modifier();
        assertEquals(m.getName(), "Unnamed Modifier");
        assertEquals(m.getPrice(), 0.0,0.1);

    }
    @Test
    public void testName(){
        m = new Modifier();
        String testName = "TestModifier";
        m.setName(testName);
        assertTrue(m.getName().equals(testName));
    }
    @Test
    public void testPrice(){
        m = new Modifier();
        double testPrice = 1.25;
        m.setPrice(testPrice);
        assertEquals(testPrice, m.getPrice(), 0.01);
    }

}
