package model;

public abstract class StoreItem {

    protected int id;
    protected String name;

    public StoreItem(int id, String name) {
        setId(id);
        setName(name);
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be positive");
        }
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public abstract void showInfo();
}