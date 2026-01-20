package menu;

import model.*;
import exception.InvalidInputException;

import java.util.ArrayList;
import java.util.Scanner;

public class StoreMenu implements Menu {

    private ArrayList<StoreItem> items = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public StoreMenu() {
        // Test data from Assignment 2
        items.add(new Product(1, "Milk", 500, 20));
        items.add(new Product(2, "Bread", 200, 30));
        items.add(new Service(3, "Delivery", 1000));

        customers.add(new Customer(101, "Prohor Tochilkin", "Regular", 5000));
    }

    @Override
    public void displayMenu() {
        System.out.println("\n=== GROCERY STORE MENU ===");
        System.out.println("1. Add Product");
        System.out.println("2. View All Items");
        System.out.println("3. Add Customer");
        System.out.println("4. View All Customers");
        System.out.println("0. Exit");
        System.out.print("Choice: ");
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> addProduct();
                    case 2 -> viewAllItems();      // POLYMORPHISM
                    case 3 -> addCustomer();
                    case 4 -> viewAllCustomers();
                    case 0 -> running = false;
                    default -> throw new InvalidInputException("Invalid menu option");
                }

            } catch (InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input type!");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private void addProduct() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();

        System.out.print("Stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        items.add(new Product(id, name, price, stock));
        System.out.println("Product added!");
    }

    private void viewAllItems() {
        System.out.println("\n--- ALL STORE ITEMS ---");
        for (StoreItem item : items) {
            item.showInfo(); // polymorphism
        }
    }

    private void addCustomer() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Membership: ");
        String level = scanner.nextLine();

        System.out.print("Total purchases: ");
        double total = scanner.nextDouble();
        scanner.nextLine();

        customers.add(new Customer(id, name, level, total));
        System.out.println("Customer added!");
    }

    private void viewAllCustomers() {
        System.out.println("\n--- ALL CUSTOMERS ---");
        for (Customer c : customers) {
            System.out.println(c);
        }
    }
}
