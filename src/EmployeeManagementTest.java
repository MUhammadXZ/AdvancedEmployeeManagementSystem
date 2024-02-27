import java.util.Date;

public class EmployeeManagementTest {
    public static void main(String[] args) {
        // Create employees
        Employee employee1 = new Employee("Ahmad Gamal", 30, "Manager");
        Employee employee2 = new Employee("Muhammad Fakhr-Eddin", 23, "Developer");
        Employee employee3 = new Employee("Muhammad Tharwat", 24, "Designer");

        // Create projects
        Project project1 = new Project("Advanced Employee Management System\n", "Muhammad Magdy", new Date(), new Date(), "Managing Employees data");
        Project project2 = new Project("Online-Courier-Management-System\n", "Ahmed Ezz", new Date(), new Date(), "managing online shop");

        // Assign employees to projects
        employee1.addProject(project1);
        employee1.addProject(project2);
        employee2.addProject(project1);
        employee3.addProject(project2);

        // Display employee information
        System.out.println("Employee Information:");
        System.out.println("====================");
        displayEmployeeInfo(employee1);
        displayEmployeeInfo(employee2);
        displayEmployeeInfo(employee3);
    }

    // Method to display employee information
    private static void displayEmployeeInfo(Employee employee) {
        System.out.println("Name: " + employee.getName());
        System.out.println("Age: " + employee.getAge());
        System.out.println("Position: " + employee.getPosition());
        System.out.println("Projects:");
        for (Project project : employee.getProjects()) {
            System.out.println("  - " + project.getProjectName());
        }
        System.out.println();
    }
}

