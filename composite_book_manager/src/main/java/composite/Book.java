package composite;

public class Book implements Item {
    private String name;
    private double price;
    private String isbn;

    public Book(String name, double price, String isbn) {
        this.name = name;
        this.price = price;
        this.isbn = isbn;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getIsbn() {
        return isbn;
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
