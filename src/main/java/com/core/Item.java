package com.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hoangocdam on 9/28/15.
 */
public class Item {
    private String name;
    private double price;
    private ArrayList<Modifier> modifierList;

    public Item(){
        this.name = "Unnamed Item";
        this.price = 0.0;
        this.modifierList = new ArrayList<>();
    }
    public Item(String name, double price, ArrayList<Modifier> modifiers) {

        this.name = name;
        this.price = price;
        if(modifiers == null) this.modifierList = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public double getPrice() {
        return this.price;
    }

    public ArrayList<Modifier> getModifiers() {
        return modifierList;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
        System.out.println(this.price);
    }

    public void setName(String s) {
        this.name = s;
    }

    public void addModifier(Modifier modifer){
        modifierList.add(modifer);
        this.price += modifer.getPrice();
    }
    public void addLotsModifier(ArrayList<Modifier> modifiers){
        for( Modifier modifier : modifiers){
            addModifier(modifier);
        }
    }

    public void sortModifierList() {
        Collections.sort(modifierList);
    }
}
