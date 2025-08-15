import java.sql.*;
import java.util.Scanner;

public class test7 {

    // Database URL, username, password
    static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    static final String USER = "root"; // your MySQL username
    static final String PASS = "Anurag@2002"; // your MySQL password

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Load MySQL Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL Driver Loaded Successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found! Please add mysql-connector-j.jar to your project.");
            e.printStackTrace();
            return; // Stop execution if driver is missing
        }

        // 2. Menu Loop
        while (true) {
            System.out.println("\n--- Student CRUD Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent(sc);
                    break;
                case 4:
                    deleteStudent(sc);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // 1. Add Student
    public static void addStudent(Scanner sc) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "INSERT INTO students (name, age, course) VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);

            sc.nextLine(); // consume newline
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            pst.setString(1, name);
            pst.setInt(2, age);
            pst.setString(3, course);

            int rows = pst.executeUpdate();
            System.out.println(rows > 0 ? "✅ Student Added Successfully" : "❌ Failed to Add Student");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 2. View Students
    public static void viewStudents() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "SELECT * FROM students";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            System.out.println("\n--- Student List ---");
            System.out.println("ID | Name | Age | Course");
            System.out.println("-------------------------");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getInt("age") + " | " +
                        rs.getString("course"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 3. Update Student
    public static void updateStudent(Scanner sc) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "UPDATE students SET name=?, age=?, course=? WHERE id=?";
            PreparedStatement pst = con.prepareStatement(sql);

            System.out.print("Enter Student ID to Update: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Enter New Name: ");
            String name = sc.nextLine();
            System.out.print("Enter New Age: ");
            int age = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Enter New Course: ");
            String course = sc.nextLine();

            pst.setString(1, name);
            pst.setInt(2, age);
            pst.setString(3, course);
            pst.setInt(4, id);

            int rows = pst.executeUpdate();
            System.out.println(rows > 0 ? "✅ Student Updated Successfully" : "❌ No Student Found");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 4. Delete Student
    public static void deleteStudent(Scanner sc) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "DELETE FROM students WHERE id=?";
            PreparedStatement pst = con.prepareStatement(sql);

            System.out.print("Enter Student ID to Delete: ");
            int id = sc.nextInt();

            pst.setInt(1, id);

            int rows = pst.executeUpdate();
            System.out.println(rows > 0 ? "✅ Student Deleted Successfully" : "❌ No Student Found");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


