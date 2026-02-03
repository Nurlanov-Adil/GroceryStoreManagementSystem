package database;

import model.Product;
import model.StoreItem;

import java.sql.*;

public class StoreItemDAO {

    public void getAllItems() {
        executeSelect("SELECT * FROM store_item");
    }

    public void getProductsOnly() {
        executeSelect("SELECT * FROM store_item WHERE type = 'PRODUCT'");
    }

    public void getServicesOnly() {
        executeSelect("SELECT * FROM store_item WHERE type = 'SERVICE'");
    }

    public void insertItem(StoreItem item) {
        String sql = """
            INSERT INTO store_item (name, price, stock, type)
            VALUES (?, ?, ?, ?)
        """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, item.getName());
            stmt.setDouble(2, item.getPrice());

            if (item instanceof Product p) {
                stmt.setInt(3, p.getStock());
                stmt.setString(4, "PRODUCT");
            } else {
                stmt.setNull(3, Types.INTEGER);
                stmt.setString(4, "SERVICE");
            }

            stmt.executeUpdate();
            System.out.println("Item inserted successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePrice(int itemId, double newPrice) {
        String sql = "UPDATE store_item SET price = ? WHERE item_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, newPrice);
            stmt.setInt(2, itemId);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Price updated");
            } else {
                System.out.println("Item not found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteItem(int itemId) {
        String sql = "DELETE FROM store_item WHERE item_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, itemId);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Item deleted");
            } else {
                System.out.println("Item not found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchByName(String keyword) {
        String sql = "SELECT * FROM store_item WHERE LOWER(name) LIKE LOWER(?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();

            printResultSet(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchByPriceRange(double min, double max) {
        String sql = "SELECT * FROM store_item WHERE price BETWEEN ? AND ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, min);
            stmt.setDouble(2, max);
            ResultSet rs = stmt.executeQuery();

            printResultSet(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchByMinPrice(double min) {
        String sql = "SELECT * FROM store_item WHERE price >= ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, min);
            ResultSet rs = stmt.executeQuery();

            printResultSet(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void executeSelect(String sql) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            printResultSet(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void printResultSet(ResultSet rs) throws SQLException {
        System.out.println("\n--- RESULTS ---");

        boolean empty = true;

        while (rs.next()) {
            empty = false;
            System.out.println(
                    rs.getInt("item_id") + " | " +
                            rs.getString("name") + " | " +
                            rs.getDouble("price") + " | " +
                            rs.getString("type")
            );
        }

        if (empty) {
            System.out.println("No items found.");
        }
    }
}