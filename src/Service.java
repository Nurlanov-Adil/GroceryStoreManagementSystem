public class Service extends StoreItem {

    private double fee;

    public Service(int id, String name, double fee) {
        super(id, name);
        this.fee = fee;
    }

    @Override
    public void showInfo() {
        System.out.println(
                "Service: " + name +
                        ", fee=" + fee
        );
    }
}
