package model.Core;


import java.math.BigDecimal;
import java.util.ArrayList;


/**
 * Created by hoangocdam on 9/28/15.
 */
public class Order {
    private int id;
    ArrayList<Item> itemList;
    BigDecimal total;

    public Order(){
        this.id = 0;
        this.itemList = new ArrayList<>();

    }
    public int getID() {
        return this.id;
    }

    public void setID(int testID) {
        this.id = testID;
    }

    public ArrayList<Item> getItems(){
        return this.itemList;
    }

    public void addItem(Item testItem) {
        itemList.add(testItem);
    }

    public BigDecimal calculateTotal(){
        itemList.forEach(i -> total.add(i.getPrice()));
        return total;
    }
    public boolean containItem(Item item){
        return itemList.contains(item);
    }
    public void transferItem(Item item, Order order) throws Exception {
        if (containItem(item)){
            order.getItems().add(item);
            itemList.remove(item);
        } else {
            throw new Exception(String.format("Item %s not found", item.name));
        }
    }

    public void transferItems(ArrayList<Item> items, Order order){
        items.stream().forEach(i -> {
            try {
                transferItem(i, order);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
