package com.core;


import java.util.ArrayList;


/**
 * Created by hoangocdam on 9/28/15.
 */
public class Order {
    private int id;
    private ArrayList<Item> itemList;

    public Order(){
        this.id = 0;
        this.itemList = new ArrayList<>();

    }
    public int getID() {
        return this.id;
    }

    public ArrayList<Item> getItems(){
        return this.itemList;
    }

    public void setID(int testID) {
        this.id = testID;
    }

    public void addItem(Item testItem) {
        itemList.add(testItem);
    }
}
