package com.project.minervapcdetails;

import java.util.ArrayList;

public class MinervaItemPCDetails {

    static String periodQtyHeader = " \\nPeriod quantity";
    static String rawScales = "To 11\n\n\nTo 12";
    static ArrayList<String> actualScales = new ArrayList<String>();

    static String rawVlidityPeriod = "Nov 2020\tDec 2020";

    public static void main(String[] args) {
        //System.out.println(periodQtyHeader.trim());


        System.out.println(getArrayOfValues(rawScales));

        System.out.println(getArrayOfValues(rawVlidityPeriod));


    }



    private static ArrayList<String> getArrayOfValues(String rawString){
        ArrayList<String> actualVals = new ArrayList<String>();
        String[] arrayOfVals = rawString.split("\\r?\\n?\\t");
        //System.out.println(arrayOfVals.length);
        int cnt = 0;
        for(String vals : arrayOfVals){
            if(!(vals.isEmpty())){
                actualVals.add(vals);
            }
        }
        System.out.println(actualVals.size());

        return actualVals;
    }


}
