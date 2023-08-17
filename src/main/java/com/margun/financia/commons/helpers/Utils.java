package com.margun.financia.commons.helpers;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Utils {

    public static String FORMAT_DATE = "yyyy-MM-dd HH:mm:ss";
    public static String getCurrenDate(){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE);
        return dateFormat.format(currentDate);
    }
}
