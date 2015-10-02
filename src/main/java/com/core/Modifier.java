package com.core;

/**
 * Created by hoangocdam on 9/28/15.
 */
public class Modifier implements Comparable<Modifier>
{
    private double deltaPrice;
    private String name;

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

    public boolean equals(Modifier other){
        return (this.name.equals(other.name) && this.deltaPrice == other.deltaPrice);
    }

    @Override
    public int compareTo(Modifier other) {
        return this.getPrice() == other.getPrice() ? 0 : this.getPrice() > other.getPrice() ? 1 : -1;
    }
}
