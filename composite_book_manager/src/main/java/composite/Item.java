package composite;

/**
 * Interface representing a general item in the Composite structure.
 */
public interface Item {

    /**
     * Returns the name of the item.
     * 
     * @return the name of the item
     */
    String getName();

    /**
     * Returns the price of the item.
     * For lists, this should return the total price of all contained items.
     * 
     * @return the price of the item
     */
    double getPrice();

    // Default method for search
    default Item findItem(String name) {
        return this.getName().equals(name) ? this : null;
    }

    default boolean changePrice(double newPrice) {
        return false; // Defaultly returns false for items that cannot change their price
    }

    default boolean removeItem(String name) {
        return false;
    }
}
