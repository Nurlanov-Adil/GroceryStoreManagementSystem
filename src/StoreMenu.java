import java.util.Scanner;
import java.util.ArrayList;

public class StoreMenu implements Menu {

    private ArrayList<StoreItem> items = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public StoreMenu() {
        items.add(new Product(1, "Milk", 500, 20));
        items.add(new Product(2, "Bread", 200, 30));
        items.add(new Service(3, "Delivery", 1000));
    }

    @Override
    public void displayMenu() {
        System.out.println("\n=== GROCERY MARKET MENU ===");
        System.out.println("1. View all items");
        System.out.println("0. Exit");
        System.out.println("Choice: ");
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
                    case 1:
                        for (StoreItem item : items) {
                            item.showInfo();
                        }
                        break;
                    case 0:
                        running = false;
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }
}