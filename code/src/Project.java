
import java.util.ArrayList;
import java.util.List;

public class Project {
    private String projectName;

    /*Arraylist for tasks
   /private ArrayList<Task> tasklist = new ArrayList<>();


   public static List<Project> projectList(){

    ArrayList<Project> plist = new ArrayList<>();
        plist.add(new Project("Project 1"));
        plist.add(new Project("Project 2"));
        plist.add(new Project("Project 3"));
        plist.add(new Project("Project 4"));

        return plist;
   }
   */

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
