package com.example.springboot.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static String milliSecondsToDate(String milliSeconds){

        long foo = Long.parseLong(milliSeconds);
        Date date = new Date(foo);
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(formatter.format(date));

        return formatter.format(date);
    }
}
