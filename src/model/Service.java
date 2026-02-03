package model;

public class Service extends StoreItem {

    public Service(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public void showInfo() {
        System.out.println(
                "Service: " + name +
                        ", fee = " + price
        );
    }
}