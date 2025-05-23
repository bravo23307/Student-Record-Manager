import java.sql.*;

public class DatabaseManager {
    private Connection conn;

    public DatabaseManager() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:students.db");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS students (name TEXT, rollNo INTEGER, marks INTEGER)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addStudent(String name, int rollNo, int marks) {
        try {
            String sql = "INSERT INTO students (name, rollNo, marks) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, rollNo);
            pstmt.setInt(3, marks);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getAllStudents() {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery("SELECT * FROM students");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
