import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Grocery Store Management System ===\n");

        Product product1 = new Product(1, "Milk", 500.0, 20);
        Product product2 = new Product(2, "Bread", 200.0, 0);
        Product product3 = new Product();

        Customer customer1 = new Customer(101, "Prohor Tochilkin", "Regular", 5000);
        Customer customer2 = new Customer(102, "Viktor Shimchishin", "Gold", 15000);

        Sale sale1 = new Sale(1001, "Prohor Tochilkin", 0.0, "2025-05-20");

        System.out.println("--- PRODUCTS ---");
        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product3);

        System.out.println("\n--- CUSTOMERS ---");
        System.out.println(customer1);
        System.out.println(customer2);

        System.out.println("\n--- SALES ---");
        System.out.println(sale1);

        System.out.println("\n--- TESTING GETTERS ---");
        System.out.println("Product name: " + product1.getName());
        System.out.println("Customer name: " + customer1.getName());
        System.out.println("Sale date: " + sale1.getDate());

        System.out.println("\n--- TESTING SETTERS ---");
        product3.setName("Cheese");
        product3.setPrice(1200);
        product3.setStockQuantity(10);
        System.out.println(product3);

        System.out.println("\n--- TESTING METHODS ---");
        System.out.println("Bread in stock: " + product2.isInStock());
        product2.restock(30);
        System.out.println("Bread after restock: " + product2.getStockQuantity());

        System.out.println("Is Viktor VIP: " + customer2.isVIP());
        customer1.addPurchase(6000);
        System.out.println("Is Prohor VIP after purchase: " + customer1.isVIP());

        sale1.addItem(450);
        sale1.addItem(1200);
        sale1.calculateDiscount(10);
        System.out.println("Sale after discount: " + sale1);

        System.out.println("\n--- FINAL STATE ---");
        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product3);
        System.out.println(customer1);
        System.out.println(customer2);
        System.out.println(sale1);

        System.out.println("\n=== ASSIGNMENT 2 DEMO ===");

        ArrayList<StoreItem> items = new ArrayList<>();

        items.add(product1);
        items.add(product2);
        items.add(new Service(3, "Delivery", 1000));

        System.out.println("\n--- POLYMORPHISM OUTPUT ---");
        for (StoreItem item : items) {
            item.showInfo();
        }

        System.out.println("\n--- INSTANCEOF CHECK ---");
        for (StoreItem item : items) {
            if (item instanceof Product) {
                System.out.println(item.name + " is a Product");
            } else if (item instanceof Service) {
                System.out.println(item.name + " is a Service");
            }
        }

        System.out.println("\n=== Program Complete ===");
    }
}
