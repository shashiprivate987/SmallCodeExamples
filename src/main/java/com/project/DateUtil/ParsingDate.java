package com.project.DateUtil;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ParsingDate
{

    public static void main (String[] args)
    {
     getCurrentDateTime();
     simpleDateFormatter();
    }

    private static void simpleDateFormatter ()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Date date = new Date();
        System.out.println(sdf.format(date));
    }

    private static void getCurrentDateTime ()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }
}
