package com.project.uiDelayRemoval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GetAllDelaysInScript
{


    public static void main (String[] args) throws IOException
    {
        int delayStCnt = 0;
        int totalDelay = 0;
        /*String current = new java.io.File( "." ).getCanonicalPath();
        System.out.println("Current dir:"+current);
        String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir using System:" +currentDir);*/


        String fileName = "testFile.groovy";

        String current = new java.io.File(".").getCanonicalPath();
        System.out.println("Current dir: "+current);
        String currentDir = System.getProperty("usr.dir");
        System.out.println("current dir using System: "+currentDir);


        File file = new File(current + "/"+"Files" + "/" + fileName);
        //String[] files = file.list();

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;

        delayDetails(delayStCnt, totalDelay, br);

    }

    private static void delayDetails (int delayStCnt,
                                      int totalDelay,
                                      BufferedReader br) throws IOException
    {
        String st;
        while ((st = br.readLine()) != null){
            //System.out.println(st);

              String delay = br.readLine();
              if(delay.contains("waitForPageToLoad")){
                  delayStCnt = delayStCnt+1;
                  int dSec = Integer.parseInt(delay.substring((delay.length()-2),(delay.length()-1)));
                  System.out.println(dSec);
                  totalDelay = totalDelay+dSec;
              }

        }
        System.out.println("Total added delay statements in the script are: "+delayStCnt);
        System.out.println("Total number of seconds of added delay in the script: "+totalDelay);
    }
}
