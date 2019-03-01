package com.sda5.todo;

import java.util.ArrayList;

public class Project {
    private String projectName;

    //Arraylist for tasks
    ArrayList<Tasks> tasklist = new ArrayList<>();


   public static ArrayList<Project> projectName(){

    ArrayList<Project> projectlist = new ArrayList<>();
        projectlist.add(new Project("Project 1"));
        projectlist.add(new Project("Project 2"));
        projectlist.add(new Project("Project 3"));
        projectlist.add(new Project("Project 4"));

        return projectlist;
   }

    public Project(String projectName){
        this.projectName = projectName;

    }

    @Override
    public boolean equals(Object projectName) {
        return this.equals(projectName.toString());
    }

    @Override
    public String toString() {
        return projectName;
    }


}
