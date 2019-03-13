package com.sda5.todoapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class View {

    Scanner sc;
    TodoController controller;
    //private ArrayList<Task> tasks;
    private List<Task> tasks;


    View(TodoController controller) {
        //this.controller = controller;
        this.sc = new Scanner(System.in);
    }

    View() {
        this.controller = new TodoController();
        this.sc = new Scanner(System.in).useDelimiter("\n");
    }

    public void start() {
        int choice = -1;
        boolean exitCondition = false;
        while (!exitCondition) {
            showMenu();
            choice = sc.nextInt();


            switch (choice) {
                // Show Task List (by date or project)
                case 1:
                    // Sub-menu Show Task List
                    System.out.println("1.Show task by Date");
                    System.out.println("2.Show task by Project");

                    // ask user for input
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            // ACTION show tasks by date
                            System.out.println(controller.printListTasksByDate());
                            break;


                        case 2:
                            // ACTION show tasks by a specific project
                            System.out.println(controller.filterListByProject(null));
                            break;
                    }
                    break;


                // Add New Task
                case 2:
                    String name;
                    Date dueDate = null;
                    String project = "";


                    System.out.println("Enter the task name");
                    name = sc.next();


                    System.out.println("Enter the project name");
                    project = sc.next();


                    System.out.println("Enter Due Date (DD-MM-YYYY)");
                    String date = sc.next();


                    try {
                        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                        dueDate = formatter.parse(date);
                    } catch (ParseException e) {
                        System.out.println("Exception : " + e);
                        System.out.println("Please check the format : dd-mm-yyyy");
                    }

                    controller.addTask(name, dueDate, project);

                    // print out some message


                    // ACTION add task


                    break;
                case 3:

                    //ACTION edit task
                    printListWithIndex(controller.printListTasksByDate());
                    System.out.println("please choose the task that you want to update:");
                    // 5 + enter
                    int index = sc.nextInt();
                    //TODO have a validator
                    System.out.println("what do you want to update: 1- projectName, 2- title, ..");

                    //updating the project name
                    String newProjectName = getUserInput("write the new project name: ");
                    controller.updateProjectName(index, newProjectName);





                    //ACTION mark as done
                    /*if (controller.taskCount() > 0) {
                        System.out.println("Select the project from below options");
                        for (Project p : TodoController.getProjects())
                            System.out.println(p);
                        project = sc.next();

                        System.out.println("Select task from the below list");

                        //Continue


                    }*/

                    break;

                case 4:
                    //ACTION remove task
                    System.out.println("Specify Project Name");
                    String projectName = sc.next();
                    System.out.println("Specify Task Name");
                    String taskName = sc.next();
                    if (controller.RemoveTask(projectName, taskName) == true)
                        System.out.println("Task Removed");
                    else
                        System.out.println("Task Not Found");
                    break;
                case 0:
                    //ACTION Quit

                    exitCondition = true;
                    break;

                // Default action for invalid menu option
                default:
                    System.out.println("Invalid Input");
                    System.out.println("Choose between 0 to 5");

                    break;

            }

        }
    }

    private String getUserInput(String message)
    {
        System.out.println(message);
        return sc.next();
    }

    private void printListWithIndex(List<Task> taskList)
    {
        //TODO why to string
        for (int index = 0; index < taskList.size(); index++)
        {
            //sout
            System.out.println(index + ") " + taskList.get(index));
        }
    }


    public void showMenu() {

        System.out.println("Welcome to ToDoLY");
        System.out.println("You have ----- tasks to do and ----- tasks are done");
        System.out.println("Pick an option:");
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task");
        System.out.println("(4) Remove Task");
        System.out.println("(5) Update task status");
        System.out.println("(0) Save and Quit");

    }

}





