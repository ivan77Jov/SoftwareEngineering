package composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Composite implements Item {
    private String name;
    private List<Item> items;

    public Composite(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * Java Stream API - used for getting the final sum of all items in our list
     * stream() method creates a stream of data of our items - sequential processing
     * of elements of the list
     * mapToDouble transforms every element in our stream into double type
     * we use a reference on the method getPrice, to get the price of every object
     * sum() method adds all prices of the list
     */
    @Override
    public double getPrice() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }

    public void addItem(Item item) {
        if (items.stream().anyMatch(existingItem -> existingItem.getName().equals(item.getName()))) { //lambda expression
            throw new IllegalArgumentException("Item with name " + item.getName() + " already exists."); 
        }
        items.add(item);
    }

    public boolean removeItem(String name) {
        // Go through all items
        for (Iterator<Item> iterator = items.iterator(); iterator.hasNext();) {
            Item item = iterator.next();
            // If the name is correct, remove
            if (item.getName().equals(name)) {
                iterator.remove();
                return true;
            }
            // Recursively search for sublists
            if (item.removeItem(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Item findItem(String name) {
        if (this.getName().equals(name)) {
            return this;
        }
        for (Item item : items) {
            Item found = item.findItem(name); // Polymorphism call
            if (found != null) {
                return found;
            }
        }
        return null;
    }

}
