package com.margun.financia.commons.helpers;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Utils {

    public static String FORMAT_TIMESTAMP = "yyyy-MM-dd HH:mm:ss";
    public static String FORMAT_DATE = "yyyy-MM-dd";

    public static String getCurrenDate(){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT_TIMESTAMP);
        return dateFormat.format(currentDate);
    }

    public static String getCurrenDate(String format){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(currentDate);
    }

    public static java.sql.Date getDate(){
        return new java.sql.Date(new Date().getTime());
    }

    public static String formatUtilDate(Date date, String format){
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }
}
