# Employee Management System

## Description
This Java application demonstrates an employee management system. It includes functionality to manage employees, projects, and salaries using a MySQL database.

## Features
- Display employees involved in projects
- Calculate average salary per position
- Update salary for employees involved in high-budget projects
- Delete old employees not involved in any projects

## Requirements
- Java Development Kit (JDK) 8 or higher
- MySQL database server
- MySQL Connector/J (JDBC driver)
- MySQL Workbench or any MySQL client tool for database management

## Setup
1. Clone the repository: `git clone https://github.com/MUhammadXZ/AdvancedEmployeeManagementSystem.git`
2. Import the project into your IDE (e.g., IntelliJ IDEA, Eclipse).
3. Set up your MySQL database server.
4. Create a database named `employee_management`.
5. Import the provided SQL script (`database_script.sql`) into your MySQL database to create the necessary tables and sample data.
6. Update the JDBC URL, username, and password in the `EmployeeManagementSQL` class according to your MySQL server configuration.

## Usage
1. Run the `EmployeeManagementSQL` class to execute the SQL queries and demonstrate the features of the employee management system.
2. View the console output to see the results of the SQL queries.
   ## Running Tests
To run the tests for the employee management system, follow these steps:

1. Ensure that you have set up the project as described in the Setup section of this README file.
2. Open your IDE (e.g., IntelliJ IDEA, Eclipse) and navigate to the project directory.
3. Locate the test classes in the source folder.
4. Right-click on the test class you want to run.
5. Select "Run <EmployeeManagementTest>" from the context menu to execute the tests.
6. Alternatively, you can run all the tests in the project by right-clicking on the `src/test/java` folder and selecting "Run All Tests" or a similar option.
7. View the test results in the IDE's test runner tool window to verify the functionality of the employee management system.

Note: Make sure that your MySQL database server is running and accessible during test execution to ensure proper database interaction.



