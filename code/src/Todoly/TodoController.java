package Todoly;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class TodoController {


    private List<Task> taskList;

    TodoController()
    {
        this.taskList = new ArrayList<>();
    }


    public void showAllTaskWithIndex(){

        for (int i=0; i<taskList.size(); i++){
            System.out.println("Task "+ i + ": " + taskList.get(i));
        }

    }


    //TODO ACTION show taskList by a specific project
    public List<Task> filterListByProject(String project)
    {
        String fProject = project;
        List<Task> filtered = taskList.stream()
                .filter(task -> task.getProject().equals(fProject) )
                .collect(Collectors.toList());

        return filtered;
    }


    // ACTION show taskList by date
    public List<Task> printListTasksByDate() {


        Collections.sort(taskList, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getDueDate().compareTo(o2.getDueDate());
            }
        });

        return taskList;

    }


    public int tasksToDo()
    {

        //String filterWord = "InProgress";
        List<Task> filtered = taskList.stream()
                .filter(task -> task.getStatus().equals("InProgress") )
                .collect(Collectors.toList());
         return filtered.size();

    }

    public int tasksDone()
    {
     //   String filterWord = "Completed";
        List<Task> filtered = taskList.stream()
                .filter(task -> task.getStatus().equals("Completed") )
                .collect(Collectors.toList());
        return filtered.size();

    }



    // Add New Task
    public void addTask(String taskName, Date date, String projectName) {
        Task t = new Task(taskName, date, projectName);
        this.taskList.add(t);
        }



    public int taskCount()
    {
        return taskList.size();
    }


    //ACTION remove task
    public boolean RemoveTask(String project, String taskName) {
        Task t;
        for (int i = 0; i < taskList.size(); i++) {
            t = taskList.get(i);

            if (t.getProject().equals(project) && t.getName().equals(taskName)) {
                this.taskList.remove(i);
                return true;
            }

        }

        return false;
    }

    public void updateProjectName(int index, String newProjectName)
    {
        taskList.get(index).setProject(newProjectName);
    }

    // ACTION get task

        // ACTION Update task Status
    public void updateStatus(int index, String newStatus)
    {

        taskList.get(index).setStatus(newStatus);

    }


    // ACTION Update task Status
    public boolean verifyTaskStatusCompleted(int index)
    {

       return  taskList.get(index).getStatus().equals("Completed");

    }


    public void save(String filename)
    {
        ObjectOutputStream objectOutputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(filename));
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(taskList);

            fileOutputStream.close();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }




    }

    public boolean load(String filename)
    {
        ObjectInputStream objectInputStream = null;

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File(filename));
            objectInputStream = new ObjectInputStream(fileInputStream);

            taskList = (ArrayList<Task>) objectInputStream.readObject();
            return true;

        } catch (IOException | ClassNotFoundException e) {
            return false;
        }
    }


}
