package model;

public class Product extends StoreItem {

    private int stock;

    public Product(int id, String name, double price, int stock) {
        super(id, name, price);
        setStock(stock);
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }
        this.stock = stock;
    }

    @Override
    public void showInfo() {
        System.out.println(
                "Product: " + name +
                        ", price = " + price +
                        ", stock = " + stock
        );
    }
}