package Todoly;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class Util {


    public static Date parseDate(String strDate) throws ParseException {
        return parseDate("dd-MM-yyyy", strDate);
    }


    public static Date parseDate(String pattern, String strDate) throws ParseException {
        Date dueDate;

        try {
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
            LocalDate dt = LocalDate.parse(strDate, dtf);

            dueDate = formatter.parse(dt.format(dtf));
        } catch (ParseException | DateTimeParseException e) {
            throw e;
        }
        return dueDate;
    }

    }
