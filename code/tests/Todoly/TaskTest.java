package Todoly;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.fail;
//import static org.junit.Assert.assertEquals;


public class TaskTest {
    Task t;

    @Test
    public void GetTaskName() {
        try {
            String taskName = "hello";
            t = new Task(taskName, Util.parseDate( "19-01-2019"), "world");

            t.getName();

            String expected = "ho" + taskName;

            // we assert equals on task.getName() with expected value
            Assertions.assertTrue(t.getName().equals(expected));
           // Assertions.assertEquals(t.getName(), expected);


        } catch (ParseException e) {
            fail();

        }


    }
}
