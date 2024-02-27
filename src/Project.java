import java.util.Date;

public class Project {
    private String projectName;
    private String projectManager;
    private Date startDate;
    private Date endDate;
    private String description;


    public Project(String projectName, String projectManager, Date startDate, Date endDate, String description) {
        this.projectName = projectName;
        this.projectManager = projectManager;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

