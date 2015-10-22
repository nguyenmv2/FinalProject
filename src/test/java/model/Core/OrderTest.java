package model.Core;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by hoangocdam on 9/28/15.
 */
public class OrderTest {
    Order order;
    @Before
    public void initialize() { order = new Order();}

    @Test
    public void initTest(){
        int testID = 0;
        ArrayList<Item> testItemList = new ArrayList<>();
        assertEquals(testID, order.getID());
        assertArrayEquals(testItemList.toArray(), order.getItems().toArray());

    }

    @Test
    public void setIDTest(){
        int testID = 100;
        order.setID(testID);
        assertEquals(testID, order.getID());
    }

    @Test
    public void addItemTest(){
        Item testItem = new Item("Test Item 1", 10.00, null);
        order.addItem(testItem);
        assertEquals(1, order.getItems().size());
        Item[] testList = {testItem};
        assertArrayEquals(testList, order.getItems().toArray());
    }
}
