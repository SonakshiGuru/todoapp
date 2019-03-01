package com.sda5.todo;

import java.util.Date;

public class Tasks {

    private String name;
    private Date dueDate;
    private Status status;
    private Project project;


    public Tasks(String name, Date dueDate, Status status, Project project) {
        this.name = name;
        this.dueDate = dueDate;
        this.status = status;
        this.project = project;
    }

    public String getName() {
        return name;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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


    private static final long serialVersionUID = 21L;
}
