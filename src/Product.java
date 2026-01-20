public class Product extends StoreItem {

    private double price;
    private int stockQuantity;

    public Product(int id, String name, double price, int stockQuantity) {
        super(id, name);
        setPrice(price);
        setStockQuantity(stockQuantity);
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setPrice(double price) {
        if (price < 0){
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    public void setStockQuantity(int stockQuantity) {
        if (stockQuantity < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }
        this.stockQuantity = stockQuantity;
    }

    public boolean isInStock() {
        return stockQuantity > 0;
    }

    @Override
    public void showInfo() {
        System.out.println(
                "Product: " + name + ", price = " + price + ", stock = " + stockQuantity
        );
    }
}