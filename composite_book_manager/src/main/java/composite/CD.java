package composite;

public class CD implements Item {
    private String name;
    private double price;

    public CD(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean changePrice(double newPrice) {
        if (newPrice > 0) {
            this.price = newPrice;
            return true;
        }
        return false;
    }

}
