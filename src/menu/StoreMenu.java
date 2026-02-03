package menu;

import database.StoreItemDAO;
import model.Product;
import model.Service;
import model.StoreItem;

import java.util.Scanner;

public class StoreMenu implements Menu {

    private final StoreItemDAO dao = new StoreItemDAO();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMenu() {
        System.out.println("""
        === GROCERY STORE MENU ===
        1. View all items
        2. View products only
        3. View services only
        4. Add product
        5. Add service
        6. Update item price / fee
        7. Delete item
        8. Search by name
        9. Search by price range
        10. Search by minimum price
        11. Polymorphism demo
        0. Exit
        """);
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume enter

            switch (choice) {

                case 1 -> dao.getAllItems();

                case 2 -> dao.getProductsOnly();

                case 3 -> dao.getServicesOnly();

                case 4 -> addProduct();

                case 5 -> addService();

                case 6 -> updateItem();

                case 7 -> deleteItem();

                case 8 -> {
                    System.out.print("Enter name keyword: ");
                    String keyword = scanner.nextLine();
                    dao.searchByName(keyword);
                }

                case 9 -> {
                    System.out.print("Min price: ");
                    double min = scanner.nextDouble();
                    System.out.print("Max price: ");
                    double max = scanner.nextDouble();
                    scanner.nextLine();
                    dao.searchByPriceRange(min, max);
                }

                case 10 -> {
                    System.out.print("Min price: ");
                    double min = scanner.nextDouble();
                    scanner.nextLine();
                    dao.searchByMinPrice(min);
                }

                case 11 -> polymorphismDemo();

                case 0 -> running = false;

                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private void addProduct() {
        System.out.print("Product name: ");
        String name = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();

        System.out.print("Stock quantity: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        dao.insertItem(new Product(0, name, price, stock));
    }

    private void addService() {
        System.out.print("Service name: ");
        String name = scanner.nextLine();

        System.out.print("Fee: ");
        double fee = scanner.nextDouble();
        scanner.nextLine();

        dao.insertItem(new Service(0, name, fee));
    }

    private void updateItem() {
        System.out.print("Enter item ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter new price / fee: ");
        double value = scanner.nextDouble();
        scanner.nextLine();

        dao.updatePrice(id, value);
    }

    private void deleteItem() {
        System.out.print("Enter item ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Confirm delete (yes/no): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {
            dao.deleteItem(id);
        } else {
            System.out.println("Deletion cancelled.");
        }
    }

    private void polymorphismDemo() {
        System.out.println("\n--- POLYMORPHISM DEMO ---");

        StoreItem milk = new Product(0, "Milk", 500, 20);
        StoreItem delivery = new Service(0, "Delivery", 1000);

        milk.showInfo();
        delivery.showInfo();
    }
}