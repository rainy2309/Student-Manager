import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentManager {

    // Thêm sinh viên
    public void addStudent(Student student) {
        String sql = "INSERT INTO Students (id, name, age) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, student.getId());
            stmt.setString(2, student.getName());
            stmt.setInt(3, student.getAge());

            stmt.executeUpdate();
            System.out.println("✅ Student added: " + student.getName());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Hiển thị toàn bộ sinh viên
    public void showStudents() {
        String sql = "SELECT * FROM Students";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("\n📋 Student List:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " - " +
                                rs.getString("name") + " - " +
                                rs.getInt("age")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa sinh viên theo ID
    public void deleteStudent(int id) {
        String sql = "DELETE FROM Students WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("🗑️ Student with ID " + id + " deleted.");
            } else {
                System.out.println("⚠️ Student not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Tìm sinh viên theo ID
    public void findStudentById(int id) {
        String sql = "SELECT * FROM Students WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("🔎 Found: " +
                            rs.getInt("id") + " - " +
                            rs.getString("name") + " - " +
                            rs.getInt("age"));
                } else {
                    System.out.println("⚠️ No student with ID " + id);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
