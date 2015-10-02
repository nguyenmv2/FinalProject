package com.core;

/**
 * Created by hoangocdam on 9/28/15.
 */
public class Modifier {
    double deltaPrice;
    String name;
    public Modifier(){
        name = "Unnamed Modifier";
        deltaPrice = 0.0;
    }
    public Modifier(String name, double price){
        this.name = name;
        this.deltaPrice = price;
    }
    public void setName(String testName) {
        this.name = testName;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.deltaPrice;
    }

    public void setPrice(double testPrice) {
        this.deltaPrice = testPrice;
    }
}
