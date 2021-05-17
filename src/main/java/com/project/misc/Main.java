package com.project.misc;

public class Main {

    public static void main(String[] args) {
        int n = 100;
       // System.out.println("Test: " + nearHundred(n));


        int a = -1;
        int b = -1;
        boolean negative = false;
        System.out.println("Test: "+ posNeg(a,b,negative));


        System.out.println("Test: "+ front22("s"));

    }


    /*
    Given an int n, return true if it is within 10 of 100 or 200. Note: Math.abs(num) computes the absolute value of a number.

    nearHundred(93) → true
    nearHundred(90) → true
    nearHundred(89) → false
     */
    private static boolean nearHundred(int n) {
        int hundred =  Math.abs(100 - n);
        int twoHundred = Math.abs(200 - n);

        if (n < 100 || n <= 110) {
            if (hundred <= 10 && hundred >= 0) {
                return true;
            } else {
                return false;
            }
        } else if (n <= 200 || n > 110 || n <= 210) {
            if (twoHundred <= 10 && twoHundred >= 0) {
                return true;
            } else {
                return false;
            }
        } else{
            return false;
        }


    }

    /*
    Given 2 int values, return true if one is negative and one is positive. Except if the parameter "negative" is true, then return true only if both are negative.


posNeg(1, -1, false) → true
posNeg(-1, 1, false) → true
posNeg(-4, -5, true) → true
     */
    public static boolean posNeg(int a, int b, boolean negative) {

        if (negative) {
            return (a < 0 && b < 0);
        }
        else {
            return ((a < 0 && b > 0) || (a > 0 && b < 0));
        }

    }



    public static String front22(String str) {

        int take = 2;
        if(take > str.length()){
            take = str.length();
        }

        String front = str.substring(0,take);
        return front + str + front;

    }



}

