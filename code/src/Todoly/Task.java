package Todoly;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable {

    private String name;
    private Date dueDate;
    private String projectName;
    private String status;

    private static final long serialVersionUID = 21L;


    public Task(String name, Date dueDate, String project) {
        this.name = name;
        this.dueDate = dueDate;
        this.projectName = project;
        this.status = "InProgress";
    }

    public String getName() {
        return name;
    }


    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }


    public Date getDueDate() {
        return dueDate;
    }


    public String getProject() { return projectName; }

    public void setProject(String projectName) { this.projectName = projectName; }


    @Override
    public String toString()
    {
        return "Taskname : " + name + "        " + "Project : " + projectName + "        " + "Due Date : " + dueDate + "        " + "Status : " + status + "\n";
    }


}
