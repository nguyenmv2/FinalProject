package model.Core;

import org.bson.BsonDocument;
import org.bson.BsonDocumentWrapper;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by hoangocdam on 9/28/15.
 */
public class Item implements Bson {
    public String name;
    public double price;
    public ArrayList<Modifier> modifierList;
    private String ID;

    public Item(){
        this.name = "Unnamed Item";
        this.price = 0.0;
        this.modifierList = new ArrayList<>();
    }
    public Item(String name, double price, ArrayList<Modifier> modifiers) {

        this.name = name;
        this.price = price;
        if(modifiers == null) this.modifierList = new ArrayList<>();
        else {
            this.modifierList = modifiers;
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String s) {
        this.name = s;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
        System.out.println(this.price);
    }

    public ArrayList<Modifier> getModifiers() {
        return modifierList;
    }

    public void setModifiers(ArrayList<Modifier> modifiers) {
        this.modifierList = modifiers;
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

    @Override
    public <TDocument> BsonDocument toBsonDocument(Class<TDocument> tDocumentClass, CodecRegistry codecRegistry) {
        return new BsonDocumentWrapper<>(this, codecRegistry.get(Item.class));
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public boolean equals(Item other) {
        return this.getName().equals(other.getName()) && this.getPrice() == other.getPrice() && this.getModifiers().equals(other.getModifiers());
    }

    public String toString() {
        StringBuilder str = new StringBuilder()
                .append("ID: " + this.getID())
                .append(" Name: " + this.getName())
                .append(" Price " + this.getPrice())
                .append(" Modifiers " + this.getModifiers().toString());
        return str.toString();
    }
}
