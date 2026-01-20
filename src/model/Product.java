package model;

public class Product extends StoreItem {

    private double price;
    private int stock;

    public Product(int id, String name, double price, int stock) {
        super(id, name);
        setPrice(price);
        setStock(stock);
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setPrice(double price) {
        if (price < 0){
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    public void setStock(int stock) {
        if(stock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }
        this.stock = stock;
    }

    public boolean isInStock() {
        return stock > 0;
    }

    @Override
    public void showInfo() {
        System.out.println(
                "Product: " + name + ", price: " + price + ", stock " + stock
        );
    }
}
