package com.project.misc;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil
{

    static final String THIRDQUARTER = "Jun-Sep";


    public static void main (String[] args)
    {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MMM-yyyy");
        String strDate = formatter.format(date);
        System.out.println("Date: "+ strDate);

        System.out.println(date.getMonth()/3+2);

        if(date.getMonth()/3+2 == 3){
            System.out.println("Quarter: "+ THIRDQUARTER);
        }

    }
}
