package com.project.misc;

import javax.print.attribute.standard.DateTimeAtCompleted;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ConvertToEpochTIme
{

    public static void main (String[] args)
    {
        //System.out.println(tsToSec8601("2016-01-01T00:00:00.000-0000"));
        //System.out.println("Date");
        getCurrentDate();

        String effectiveFromDate;
        String effectiveToDate;
        effectiveFromDate = String.valueOf(getEffectiveFromDate(new Date(),
            0).getTimeInMillis());

        effectiveToDate = String.valueOf(getEffectiveToDate(new Date(),
            0).getTimeInMillis());

        System.out.println(effectiveFromDate);
        System.out.println(effectiveToDate);
    }

    public static Integer tsToSec8601 (String timestamp)
    {
        if (timestamp == null)
            return null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
            Date dt = sdf.parse(timestamp);
            long epoch = dt.getTime();
            return (int)(epoch / 1000);
        }
        catch (ParseException e) {
            return null;
        }
    }



    public static void getCurrentDate(){
        Calendar c = Calendar.getInstance();   // this takes current date
       // c.set(Calendar.DAY_OF_MONTH, 1);
        c.add(Calendar.DATE, -2);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("BomValidFrom", sdf.format(c.getTime()));

        System.out.println("DAte: "+ sdf.format(c.getTime()));
    }


    public static Calendar getEffectiveFromDate(Date date, int monthCount) {
        Calendar calendar = Calendar.getInstance();
        if (date == null) {
            calendar.setTime(new Date());
        } else {
            calendar.setTime(date);
        }

        calendar.add(2, monthCount);
        int year = calendar.get(1);
        int month = calendar.get(2);
        calendar.clear();
        calendar.set(1, year);
        calendar.set(2, month);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar;
    }


    public static Calendar getEffectiveToDate(Date date, int monthCount) {
        Calendar calendar = getEffectiveFromDate(date);
        calendar.add(2, monthCount);
        calendar.set(5, calendar.getActualMaximum(5));
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 999);
        return calendar;
    }

    public static Calendar getEffectiveFromDate(Date date) {
        return getEffectiveFromDate(date, 0);
    }
}