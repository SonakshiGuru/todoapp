package Todoly;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
//import static org.junit.Assert.assertEquals;


public class TaskTest {
    private Task t;
    private String name = "TaskName X";
    private String date = "10-10-2019";
    //private SimpleDateFormat formatter = new SimpleDateFormat("DD-MM-YYYY");
    //private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("DD-MM-YYYY");
    // private LocalDate dt = LocalDate.parse(date, dtf);
    // private Date dueDate = formatter.parse(dt.format(dtf));

    private String status = "Complete";
    private String project = "Mission Impossible";

/*
    public TaskTest(){
        t = new Task(name, Util.parseDate(date), project);
    }*/


    @Test
    public void GetTaskName() {
        try {
            assertEquals(project, t.getName());
            System.out.println("Test Successful !");
        } catch (Exception e) {
            System.out.println("Test Failed !");
        }

    }

    @Test
    public void GetTaskName2() {
        try {
            assertNotEquals(date, t.getName());
            System.out.println("Test Successful !");
        } catch (Exception e) {
            System.out.println("Test Failed !");
        }
    }



        /*try {
            String taskName = "hello";
            t = new Task(taskName, Util.parseDate( "19-01-2019"), "world");

            t.getName();

            String expected = "ho" + taskName;

            // we assert equals on task.getName() with expected value
            Assertions.assertTrue(t.getName().equals(expected));
           // Assertions.assertEquals(t.getName(), expected);


        } catch (ParseException e) {
            fail();

        }*/

}
