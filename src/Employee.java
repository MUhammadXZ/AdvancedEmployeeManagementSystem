import java.util.ArrayList;
import java.util.List;

public class Employee extends Person implements ContractDepartment {
    private String position;
    private double salary;
    private String entryDate;
    private int contractDuration;
    private int noticePeriod;
    private List<Project> projects;


    public Employee(String name, int age, String position) {
        super(name, age, position);
        this.position = position;
        this.projects = new ArrayList<>();
    }


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    // Method to calculate salary based on position
    public void calculateSalary() {
        if (position.equalsIgnoreCase("manager")) {
            salary = 5000; // Example: Salary formula for managers
        } else if (position.equalsIgnoreCase("developer")) {
            salary = 4000; // Example: Salary formula for developers
        } else if (position.equalsIgnoreCase("designer")) {
            salary = 3500; // Example: Salary formula for designers
        } else {
            salary = 3000; // Default salary for other positions
        }
    }


    public double getSalary() {
        return salary;
    }

    public List<Project> getProjects() {
        return projects;
    }


    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }


    @Override
    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    @Override
    public void setContractDuration(int contractDuration) {
        this.contractDuration = contractDuration;
    }

    @Override
    public void setNoticePeriod(int noticePeriod) {
        this.noticePeriod = noticePeriod;
    }

    // Method to add a project
    public void addProject(Project project) {
        projects.add(project);
    }

    // Method to remove a project
    public void removeProject(Project project) {
        projects.remove(project);
    }
}

