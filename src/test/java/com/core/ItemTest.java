package com.core;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

/**
 * Created by hoangocdam on 9/28/15.
 */
public class ItemTest {
    Item item;

    @Before
    public void initialize() { item = new Item();}

    @Test
    public void initTest() {
        String testString = "Unnamed Item";
        double testPrice = 0.0;
        ArrayList<Modifier> testModifierList = new ArrayList<>();

        assertEquals(testString, item.getName());
        assertEquals(testPrice, item.getPrice(), 0.01);
        assertArrayEquals(new ArrayList<Modifier>().toArray() ,testModifierList.toArray());
    }
    @Test
    public void constructorTest(){
        String testName = "Item 1";
        double testPrice = 10.00;
        ArrayList<Modifier> testModifierList = new ArrayList<>();
        testModifierList.add(new Modifier());
        item = new Item(testName, testPrice, testModifierList);
        assertEquals(testName, item.getName());
        assertEquals(testPrice, item.getPrice(), 0.1);
        assertEquals(1, item.getModifiers().size());

    }

    @Test
    public void setPriceTest(){
        double testPrice = 10.00;
        item.setPrice(testPrice);
        assertEquals(testPrice, item.getPrice(), 0.01);
    }

    @Test
    public void setNameTest(){
        String testName = "Test Item";
        item.setName("Test Item");

        assertEquals(testName, item.getName());
    }

    @Test
    public void addModifierTest(){
        Modifier m = new Modifier();
        item.addModifier(m);
        ArrayList<Modifier> result = item.getModifiers();
        assertEquals(result.size(), 1);
        assertEquals(m, result.get(0));
    }

    @Test
    public void addLotsModifierTest(){
        int num_iter = 100;
        ArrayList<Modifier> list = new ArrayList<>();
        for ( int i = 0; i < num_iter; i++){
            String name = "Test Item "+i;
            Modifier m = new Modifier (name, 0.0);
            list.add(m);
        }
        item.addLotsModifier(list);

        Collections.sort(list);
        item.sortModifierList();

        assertArrayEquals(list.toArray(),item.getModifiers().toArray());
    }
    @Test
    public void testEqual(){
        Modifier m = new Modifier("Test Modifier", 0.0);
        Modifier n = new Modifier("Test Modifier", 0.0);
        assertTrue(m.equals(n));


    }

}
