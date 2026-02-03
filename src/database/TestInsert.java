import database.StaffDAO;
import model.Staff;

public class TestInsert {
    public static void main(String[] args) {

        Staff staff = new Staff(0, "Aibek", 450000, 3);

        StaffDAO dao = new StaffDAO();
        dao.insertStaff(staff);
    }
}
