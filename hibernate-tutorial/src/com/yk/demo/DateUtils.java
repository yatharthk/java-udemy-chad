package com.yk.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

//    format for date = dd:MM:yyyy

    private static SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
    public static Date parseDate(String dateStr) throws ParseException{
        Date theDate = formatter.parse(dateStr);
        return theDate;
    }

    public static String formatDate(Date theDate) {
        String result= null;

        if(null!= theDate) {
            result = formatter.format(theDate);
        }
        return result;
    }
}
