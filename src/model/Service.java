package model;

public class Service extends StoreItem {

    private double fee;

    public Service(int id, String name, double fee) {
        super(id, name);
        setFee(fee);
    }

    public void setFee(double fee) {
        if (fee < 0) {
            throw new IllegalArgumentException("Fee cannot be negative");
        }
        this.fee = fee;
    }

    @Override
    public void showInfo() {
        System.out.println(
                "Service: " + name +
                        ", fee = " + fee
        );
    }
}
