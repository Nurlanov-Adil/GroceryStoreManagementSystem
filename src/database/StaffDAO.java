package database;

import model.Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StaffDAO {

    public void insertStaff(Staff staff) {

        String sql = "INSERT INTO staff (name, salary, experience_years) VALUES (?, ?, ?)";

        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, staff.getName());
            statement.setDouble(2, staff.getSalary());
            statement.setInt(3, staff.getExperienceYears());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Staff inserted successfully!");
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Insert failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
}
