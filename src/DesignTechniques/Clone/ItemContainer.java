package DesignTechniques.Clone;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dale on 17/07/16.
 */
public class ItemContainer {

    private static class Item implements Cloneable{
        private String itemName;
        private String itemPrice;

        public Item(String itemName,String itemPrice){
            this.itemName = itemName;
            this.itemPrice = itemPrice;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public String getItemPrice() {
            return itemPrice;
        }

        public void setItemPrice(String itemPrice) {
            this.itemPrice = itemPrice;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {

            return new Item(this.itemName,this.itemPrice);

        }
    }

    private final ArrayList<Item> items = new ArrayList<Item>(){
        {
            add(new Item("itemOne","19.99"));
            add(new Item("itemTwo","20.99"));
        }
    };


    public List<Item> getItems(){
        return (List<Item>) items.clone();
    }

    public List<Item> getDeepCopyItems(){
        ArrayList arrayList = new ArrayList(items.size());

        for(Item i: items){
            try {
                arrayList.add(i.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }

        return arrayList;
    }

    public void printAllItems(){
        for(Item item:getItems()){
            System.out.println(item.getItemName() + " " + item.getItemPrice());
        }
    }

    public boolean areEqual(ArrayList<Item> items){
        return items == this.items;
    }

    public static void main(String[] args) {
        ItemContainer i = new ItemContainer();

        System.out.println("Printing all items");
        i.printAllItems();

        System.out.println("Attempting to modify items from returned list");
        i.getItems().add(new Item("itemThreeo", "29.99"));

        i.printAllItems();
        System.out.println("As you can see, adding a new item to the returned list had no affect on the list within item container");
        System.out.println("this is because we have returned a new copy of the list with the same object references.");
        System.out.println("however, only list operations do not effect the item containers internals, if we want to stop the items themselves from being modified");
        System.out.println("we have to clone them too");


        for (Item it : i.getDeepCopyItems()) {
            it.setItemName("newItemName");
            it.setItemPrice("newItemPrice");
        }

        System.out.println("Should remain the same:");
        i.printAllItems();


        System.out.println("Should modify:");
        for (Item item : i.getItems()) {
            item.setItemName("newName");
            item.setItemPrice("newPrice");
        }

        i.printAllItems();
    }
}
