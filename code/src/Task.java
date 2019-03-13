
import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable {

    private String name;
    private Date dueDate;
    private boolean status;
    private String projectName;
    private boolean completed;

    //


    public Task(String name, Date dueDate, boolean status, String project) {
        this.name = name;
        this.dueDate = dueDate;
        this.status = status;
        this.projectName = project;
    }

    public Task(String name, Date dueDate, String project) {
        this.name = name;
        this.dueDate = dueDate;
        this.completed = false;
        this.projectName = project;
    }

    public String getName() {
        return name;
    }

    public String getStatusString()
    {
        if (status == true)
            return "done";
        else
            return "unDone";
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProject() { return projectName; }

    public void setProject(String projectName) { this.projectName = projectName; }

    private static final long serialVersionUID = 21L;

    @Override
    public String toString()
    {
        return name + "----" + projectName + "----" + dueDate + "----" + getStatusString();
    }


}
