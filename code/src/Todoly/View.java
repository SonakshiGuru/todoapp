package Todoly;

import java.text.ParseException;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class View {

    Scanner sc;
    TodoController controller;
    Util util;
    String filename;
    private List<Task> tasks;


    View(TodoController controller) {
        this.sc = new Scanner(System.in);
    }

    View() {
        this.controller = new TodoController();
        // load stores tasks

        this.filename = "data.txt";
        boolean loadFileSuccess = this.controller.load(filename);
        if (!loadFileSuccess) {
            System.out.println("Unable to find file:" + this.filename);
        }

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
                    if(controller.taskCount()>0) {
                        System.out.println("1.Show ALL tasks");
                        System.out.println("2.Show task by Date");
                        System.out.println("3.Show task by Project");

                        // ask user for input
                        choice = sc.nextInt();
                        switch (choice) {
                            case 1:
                                controller.showAllTaskWithIndex();
                                break;

                            case 2:
                                // ACTION show tasks by date
                                System.out.println(controller.printListTasksByDate());
                                break;


                            case 3:
                                // ACTION show tasks by a specific project
                                System.out.println("Enter the Project Name");
                                String project = sc.next();
                                System.out.println(controller.filterListByProject(project));
                                break;
                        }
                    }
                    else {
                        System.out.println("<<<<< No Task to Show >>>>>");
                        System.out.println("Goto option 2 to ADD new tasks" + "\n");
                        System.out.println("#####################################################" + "\n");
                    }
                    break;


                // Add New Task
                case 2:
                    String name;
                    Date dueDate = null;
                    String project = "";


                    System.out.print("Enter the task name:\n>> ");
                    name = sc.next();


                    System.out.println("Enter the project name:\n>> ");
                    project = sc.next();


                    System.out.println("Enter Due Date (DD-MM-YYYY)\n>> ");
                    String date = sc.next();

                    String datePattern = "dd-MM-yyyy";

                        try {
                            // parse a string date into type Date
                            dueDate = Util.parseDate(datePattern, date);

                            // add task
                            controller.addTask(name, dueDate, project);
                            System.out.println("\n----------------------------------");
                            System.out.println(" <<<<< TASK ADDED >>>>>");
                            System.out.println("----------------------------------");


                        } catch (ParseException | DateTimeParseException e) {
                            //System.out.println("Exception : " + e);
                            System.out.println("\n[ERROR] Could not add Task. Please try again with a valid date (DD-MM-YYYY)\n");
                            System.out.println("--------------------------------------------------------------------------------");
                        }


                    break;
                case 3:

                    //ACTION edit task
                    if(controller.taskCount()>0) {
                        System.out.println("---------------------------------------------------------------------");
                        controller.showAllTaskWithIndex();
                        System.out.println("---------------------------------------------------------------------\n");
                        System.out.println("Please choose the task number that you want to update:");
                        int index = sc.nextInt();
                        //TODO have a validator
                        System.out.println("What do you want to update:");
                        System.out.println("[1] Project Name");
                        System.out.println("[2] Status");
                        choice = sc.nextInt();
                        switch (choice) {
                            case 1:
                                String newProjectName = getUserInput("Write the new project name: ");
                                controller.updateProjectName(index, newProjectName);
                                break;

                            case 2:
                                System.out.println(("Mark the status as:\n [1] Completed \n [2] In Progress "));
                                int userAnswer = sc.nextInt();
                                switch (userAnswer){
                                    case 1 :
                                        if(!controller.verifyTaskStatusCompleted(index))
                                            controller.updateStatus(index, "Completed");
                                        else
                                            {
                                            System.out.println("Status is already Completed. To change to In Progress choose option 2\n");
                                            System.out.println("-----------------------------------------------------------------------\n");
                                            }
                                    break;

                                    case 2 :
                                        controller.updateStatus(index, "In Progress");
                                }

                                // check if yes or no

                                // TODO Fix Update Status
                                //controller.updateStatus(index, newStatus);
                                break;

                            default:
                                System.out.println("<<<<< INVALID INPUT >>>>>");

                                break;

                        }
                    }
                    else {
                        System.out.println("<<<< NO TASK ADDED >>>>");
                        System.out.println("Goto option 2 to ADD new task" +"\n");
                        System.out.println("#############################################################" + "\n");
                    }


                    break;

                case 4:
                    //ACTION remove task
                    controller.showAllTaskWithIndex();
                    System.out.println("Specify Project Name");
                    String projectName = sc.next();
                    System.out.println("Specify Task Name");
                    String taskName = sc.next();
                    if (controller.RemoveTask(projectName, taskName) == true) {
                        System.out.println("---------------------------------------------------------");
                        System.out.println("<<<<< TASK REMOVED >>>>>");
                        System.out.println("---------------------------------------------------------");
                    }
                    else {
                        System.out.println("---------------------------------------------------------");
                        System.out.println("<<<<< Task Not Found >>>>>");
                        System.out.println("---------------------------------------------------------");
                    }
                    break;
                case 0:
                    //ACTION Quit
                    System.out.println("<<<<< THANK YOU FOR USING TODOLY >>>>>");
                    controller.save(this.filename);
                    exitCondition = true;
                    break;

                // Default action for invalid menu option
                default:
                    System.out.println("<<<<<  INVALID INPUT >>>>>");
                    System.out.println("Choose between 0 to 4");
                    System.out.println("----------------------------------------------------");

                    break;

            }

        }
    }

    private String getUserInput(String message)
    {
        System.out.println(message);
        return sc.next();
    }



    public void showMenu() {
        System.out.println("#####################################################################################");
        System.out.println("WELCOME TO ToDoLY");
        System.out.println("You have " + controller.tasksToDo() + " tasks TODO and " + controller.tasksDone() + " tasks are DONE");
        System.out.println("Pick an option:");
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task");
        System.out.println("(4) Remove Task");
        System.out.println("(0) Save and Quit");
        System.out.println(" ####################################################################################");

    }

}





