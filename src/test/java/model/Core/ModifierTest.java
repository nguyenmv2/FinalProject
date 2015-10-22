package model.Core;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by hoangocdam on 9/28/15.
 */
public class ModifierTest {
    Modifier m;
    @Before
    public void setupTest(){

        m = new Modifier();
    }
    @Test
    public void initialTest(){

        assertEquals(m.getName(), "Unnamed Modifier");
        assertEquals(m.getPrice(), 0.0,0.1);

    }
    @Test
    public void testName(){
        String testName = "TestModifier";
        m.setName(testName);
        assertTrue(m.getName().equals(testName));
    }
    @Test
    public void testPrice(){
        double testPrice = 1.25;
        m.setPrice(testPrice);
        assertEquals(testPrice, m.getPrice(), 0.01);
    }


}
