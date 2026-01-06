public class Product extends StoreItem {

    private double price;
    private int stockQuantity;

    public Product(int id, String name, double price, int stockQuantity) {
        super(id, name);
        setPrice(price);
        setStockQuantity(stockQuantity);
    }

    public Product() {
        super(0, "Unknown Product");
        this.price = 0.0;
        this.stockQuantity = 0;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    public void setStockQuantity(int stockQuantity) {
        if (stockQuantity >= 0) {
            this.stockQuantity = stockQuantity;
        }
    }

    public boolean isInStock() {
        return stockQuantity > 0;
    }

    public void restock(int amount) {
        if (amount > 0) {
            stockQuantity += amount;
        }
    }

    @Override
    public void showInfo() {
        System.out.println(
                "Product: " + name +
                        ", price=" + price +
                        ", stock=" + stockQuantity
        );
    }

    @Override
    public String toString() {
        return "Product{id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                '}';
    }
}


