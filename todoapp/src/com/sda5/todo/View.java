package com.sda5.todo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static com.sda5.todoapp.Project.*;

public class View {


    public int menu(){

        System.out.println("Welcome to ToDoLY");
        System.out.println("You have ----- tasks to do and ----- tasks are done");
        System.out.println("Pick an option:");
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task (update, mark as done)");
        System.out.println("(4) Remove Task");
        System.out.println("(5) Save and Quit");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        return choice;

    }

    public void menuChoices(){
        int choice = menu();
        if(choice==1){
            show();

        }
        else if(choice==2){
            addNew();

        }
        else if(choice==3){
            edit();

        }
        else if(choice==4){
            remove();

        }
        else if(choice==5){
            save();
            //exit
            System.exit(0);

        }
        else{
            System.out.println("PICK BETWEEN 1 to 5");
        }
    }

    public void addNew(){
        String name;
        Date dueDate;
        Project project;
        Status status;

        System.out.println("Enter the task name");
        Scanner scan = new Scanner(System.in);
        name = scan.nextLine();


        System.out.println("Enter Due Date (DD-MM-YY)");
        String date = scan.next();
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yy");
            dueDate = formatter.parse(date);
        }catch (ParseException e){
            System.out.println("Exception : " + e);
            System.out.println("Please check the format : dd-mm-yy");
        }

        System.out.println("Select Project");
        ArrayList p = Project.projectName();
        System.out.println(p);





        System.out.println("Enter Status");


        new Tasks(name,dueDate,status,project);

    }
    public void show(){

    }
    public void edit(){

    }
    public void remove(){

    }
    public void save(){

    }





    }
}
