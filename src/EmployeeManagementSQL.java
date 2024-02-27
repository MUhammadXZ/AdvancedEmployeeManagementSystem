import java.sql.*;

public class EmployeeManagementSQL {

    static final String JDBC_URL = "jdbc:mysql://localhost:3306/advanced employee management system";
    static final String USERNAME = "springstudent";
    static final String PASSWORD = "springstudent";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            // Task 1: Display employees involved in at least two projects and show the project names alongside employee data
            displayEmployeesWithMultipleProjects(connection);

            // Task 2: Calculate the average salary rate per position and display it in ascending order
            calculateAverageSalaryPerPosition(connection);

            // Task 3: Update the salary of all employees by 10% if they are involved in a project with a budget exceeding 100,000 euros
            updateSalaryForHighBudgetProjects(connection);

            // Task 4: Delete all employees older than 40 years who are not involved in any projects
            deleteOldEmployeesNotInvolvedInProjects(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Task 1: Display employees involved in at least two projects and show the project names alongside employee data
    public static void displayEmployeesWithMultipleProjects(Connection connection) throws SQLException {
        String sql = "SELECT e.employee_id, e.name AS employee_name, e.position, " +
                "p.project_id, p.name AS project_name " +
                "FROM Employees e " +
                "JOIN (SELECT employee_id, COUNT(*) AS project_count " +
                "      FROM Projects " +
                "      GROUP BY employee_id " +
                "      HAVING COUNT(*) >= 2) p_count " +
                "ON e.employee_id = p_count.employee_id " +
                "JOIN Projects p ON e.employee_id = p.employee_id";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            // Process the result set
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String position = resultSet.getString("position");
                int projectId = resultSet.getInt("project_id");
                String projectName = resultSet.getString("project_name");

                System.out.println("Employee ID: " + employeeId +
                        ", Name: " + employeeName +
                        ", Position: " + position +
                        ", Project ID: " + projectId +
                        ", Project Name: " + projectName);
            }
        }
    }

    // Task 2: Calculate the average salary rate per position and display it in ascending order
    public static void calculateAverageSalaryPerPosition(Connection connection) throws SQLException {
        String sql = "SELECT position, AVG(salary) AS average_salary " +
                "FROM Employees " +
                "GROUP BY position " +
                "ORDER BY average_salary ASC";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            // Process the result set
            while (resultSet.next()) {
                String position = resultSet.getString("position");
                double averageSalary = resultSet.getDouble("average_salary");

                System.out.println("Position: " + position +
                        ", Average Salary: " + averageSalary);
            }
        }
    }

    // Task 3: Update the salary of all employees by 10% if they are involved in a project with a budget exceeding 100,000 euros
    public static void updateSalaryForHighBudgetProjects(Connection connection) throws SQLException {
        String sql = "UPDATE Employees " +
                "SET salary = salary * 1.1 " +
                "WHERE employee_id IN (SELECT employee_id " +
                "                      FROM Projects " +
                "                      WHERE budget > 100000)";

        try (Statement statement = connection.createStatement()) {
            int rowsAffected = statement.executeUpdate(sql);
            System.out.println("Updated salary for " + rowsAffected + " employees.");
        }
    }

    // Task 4: Delete all employees older than 40 years who are not involved in any projects
    public static void deleteOldEmployeesNotInvolvedInProjects(Connection connection) throws SQLException {
        String sql = "DELETE FROM Employees " +
                "WHERE age > 40 " +
                "AND employee_id NOT IN (SELECT employee_id FROM Projects)";

        try (Statement statement = connection.createStatement()) {
            int rowsAffected = statement.executeUpdate(sql);
            System.out.println("Deleted " + rowsAffected + " old employees not involved in any projects.");
        }
    }
}

