package model.Core;

import org.bson.BsonDocument;
import org.bson.BsonDocumentWrapper;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

/**
 * Created by hoangocdam on 9/28/15.
 */
public class Modifier implements Bson, Comparable<Modifier> {

    private double deltaPrice;
    private String name;


    private String id;

    public Modifier() {
        name = "Unnamed Modifier";
        deltaPrice = 0.0;
    }

    public Modifier(String name, double price) {
        this.name = name;
        this.deltaPrice = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String testName) {
        this.name = testName;
    }

    public double getPrice() {
        return this.deltaPrice;
    }

    public void setPrice(double testPrice) {
        this.deltaPrice = testPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean equals(Modifier other) {
        return (this.name.equals(other.name) && this.deltaPrice == other.deltaPrice);
    }


    @Override
    public <TDocument> BsonDocument toBsonDocument(Class<TDocument> tDocumentClass, CodecRegistry codecRegistry) {
        return new BsonDocumentWrapper<>(this, codecRegistry.get(Modifier.class));
    }

    @Override
    public int compareTo(Modifier other) {
        return this.getPrice() < other.getPrice() ? -1 :
                this.getPrice() == other.getPrice() ? 0 : 1;
    }

    public String toString() {
        StringBuilder str = new StringBuilder()
                .append("ID " + this.getId())
                .append("Name " + this.getName())
                .append("Delta Price " + this.getPrice());
        return str.toString();
    }
}
