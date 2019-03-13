
import java.util.*;

public class TodoController {

    // TODO change name of class Task to Task
    private List<Task> taskList;
    //private static List<Project> projects = Arrays.asList(new Project("Project 1"), new Project("Project 2"), new Project("Project 3"));

    TodoController() {
        this.taskList = new ArrayList<>();
    }

    //TODO ACTION show taskList by a specific project
    public List<Task> filterListByProject(String project)
    {
        //ask the user which project and this will be parameter
        //taskList.stream().filter().collect()
        return null;
    }

    /*public List<Task> printListTasksByProjectName() {
        Collections.sort(taskList, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getProject().compareTo(o2.getProject());
            }
        });
         return taskList;

    }*/

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

    // Add New Task
    public void addTask(String taskName, Date date, String projectName) {
        Task t = new Task(taskName, date, projectName);
        this.taskList.add(t);
        }



    public int taskCount(){
        return taskList.size();
    }


    /*public static List<Project> getProjects() {
        return projects;
    }*/


    //ACTION edit task
    public void editTask(String project, String taskName) {
        Task t;
        System.out.println("Do you want to update the Status? Y/N");





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


}
