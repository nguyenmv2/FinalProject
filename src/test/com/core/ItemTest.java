package com.core;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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
        assertTrue(testEqualArrayList(testModifierList, item.getModifiers()));
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


    public boolean testEqualArrayList(ArrayList<?> first, ArrayList<?> second){
        for ( Object element : first ){
            for (Object ele : second){
                if ( ele.equals(element)) {
                    break;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
