package com.projects.learning.exercises;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        int[] arrayA = {5,4,12,7,15,9};
        int[] arrayB = new int[5];

        for(int i=arrayA.length-1; i>=0; i--){
            System.out.print(arrayA[i]);
        }

    }
}

class TestClass1{

    public static void main(String[] args) throws IOException {
        //BufferedReader
        int arraySize = 0;

        int[] arrayA = {1,2,3,4,5};
        int[] arrayB = {4,5,3,2,10};

        System.out.println("Enter the size of array \n");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arraySize = Integer.parseInt(br.readLine());                // Reading input from STDIN
        System.out.println("Array Size " + arraySize);    // Writing output to STDOUT

        int[] arraySum = new int[arraySize];
        for (int i=0; i<arraySize; i++){
            arraySum[i] = arrayA[i] + arrayB[i];
        }

        System.out.println("Sum: \n"+ Arrays.toString(arraySum));

    }


}

class AddArrays {

    public static void main(String[] args) throws IOException {

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        int N = Integer.parseInt(line1);

        String line2 = br.readLine();
        String[] arrayStrA = line2.split(" ");
        int[] arrayA = new int[N];


        String line3 = br.readLine();
        String[] arrayStrB = line3.split(" ");
        int[] arrayB = new int[N];

        int i = 0;
        for (String str : arrayStrA) {
            arrayA[i] = Integer.parseInt(str);
            i++;
        }

        int j = 0;
        for (String str : arrayStrB) {
            arrayB[j] = Integer.parseInt(str);
            j++;
        }

        int[] arraySum = new int[N];

        for (int k = 0; k < N; k++) {
            arraySum[k] = arrayA[k] + arrayB[k];
        }


        String myArr = Arrays.toString(arraySum);

        System.out.println(myArr.replace("[", "").replace("]", "").replace(",", ""));

    }
}


 class FirstOccurrence {

     public static void main(String[] args) {
         String str = "shashi";
         int len = str.length();
         char[] charArrA = new char[len];
         char[] charArrB = new char[len];
         for (int i = 0; i < charArrA.length; i++) {

            //charArrA[i] = str.charAt(0);
            boolean flag = false;
             for(int j=0; j<=i; j++){


                 if(str.charAt(i) == charArrA[j]){
                     flag = true;
                     break;
                 }


             }
             if(!flag){
                 charArrA[i] = str.charAt(i);
                 System.out.print(charArrA[i]);
             }

         }


         //System.out.println(Arrays.toString(charArr));

     }

}

class VowelPhobia {

    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println(System.getProperty("user.dir"));
       // URL path = ClassLoader.getSystemResource("/controller/VowelPhobia.txt");
        //File file = new File(path.toURI());
        BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/src/main/java/com/quickpicktech/springboot/controller/VowelPhobia.txt"));
        int N = Integer.parseInt(br.readLine());
        System.out.println(N);

        for(int i=0;i<N;i++){
            String str = br.readLine();
            getvowelCount(str);
        }
    }

    private static void getvowelCount(String str) {
        int cnt = 0;
        char[] charArrayA = str.toLowerCase().toCharArray();
        for(int i=0; i<charArrayA.length;i++){

            if(charArrayA[i] == 'a' || charArrayA[i] == 'e' || charArrayA[i] == 'i' || charArrayA[i] == 'o' || charArrayA[i] == 'u' ){
                cnt++;
            }

        }
        System.out.println(cnt);
    }


}

class Pallindrome{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/src/main/java/com/quickpicktech/springboot/controller/Pallindrome.txt"));
        int N = Integer.parseInt(br.readLine());
        System.out.println(N);

        for(int i=0;i<=N;i++){
            String str = br.readLine();
            boolean b = checkPalindrome(str);
            if(b){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }

    private static boolean checkPalindrome(String str) {

        char[] pal = str.toLowerCase().toCharArray();

        int i = 0 , j = str.length()-1;
        while (i<j){

            if(pal[i] != pal[j]){
                return false;
            }

            i++;
            j--;
        }

        return true;
    }


}


class ATMQueue{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N=s.nextInt();int i,count=1;
        int h[]=new int[N];
        for(i=0;i<N;i++)
        {
            h[i]=s.nextInt();

        }
        for(i=0;i<N-1;i++)
        {
            if(h[i]-h[i+1]>0)
            {
                count++;
            }
        }
        System.out.print(count);
    }

}


class SubSetOfAnArray {
    public static void main(String[] args) {
        char set[] = {'a', 'b', 'c'};
        printSubSets(set);
    }

    private static void printSubSets(char[] set) {

        int n = set.length;

        // Run a loop for printing all 2^n
        // subsets one by obe
        for(int i=0; i< (1<<n) ; i++){
            System.out.print("{ ");
            //System.out.println(i);
            // Print current subset
            for(int j=0; j< n; j++){

                boolean b = isVal(i,j);
                if(b){
                    System.out.print(set[j] + " ");
                }
                /*if ((i & (1 << j)) > 0){
                    System.out.print(set[j] + " ");
                }*/
            }
            System.out.println("}");
        }
    }

    private static boolean isVal(int i, int j){

        //System.out.println(i);
        //System.out.println(1<<j);
        if ((i & (1 << j)) > 0){
            return true;
        }

        return false;
    }
}

class IntToBinaryNotation{

    public static void main(String[] args) {

        int n = 3245;

        System.out.println("Integer value: "+ n);

        toBinary(n);

    }

    private static void toBinary(int n) {
        if(n !=0){
            while (n > 0){
                int x = n % 2;
                System.out.print(x);
                n /= 2;
            }
        }
    }
}

class NumberSorting {

    public static void main(String[] args) {

        int temp;

        int[] a = new int[]{56,4, 2, 7, 1, 8, 5};

        int cnt = a.length;
        int[] sortedArray = sortNumbers(a, cnt);

        for (int i=0; i< cnt; i++){
            System.out.print(sortedArray[i]+ " ");
        }

    }

    private static int[] sortNumbers(int[] a, int cnt) {
        int temp;
        for(int i = 0; i < cnt; i++){
            //System.out.println(a[i]);

            for(int j = i+1; j< cnt; j++){

                if(a[i] > a[j]){

                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }

            }
        }

        return a;
    }
}

class FindMissingNumber {

    public static void main(String[] args) {

        int n;
        int[] a = {1,2,3,5,6};
        n = a.length;

       int missedNum =  getMissingNumber(a, n);
        System.out.println("Missed Number: "+missedNum);
    }

    private static int getMissingNumber(int[] a, int n){

        int total = 0;

        total = ((n+1)*(n+2))/2;

        for(int i=0; i < n; i++){
            total -= a[i];
        }

        return total;
    }
}

class MissingNumber2 {

    public static void main(String[] args) {
        int gap;
        int[] arrayA = {2,4,6,8,18};

        gap = arrayA[1] - arrayA[0];

       int[] num = missingNum(arrayA, gap);

       for(int j=1; j<num.length; j++){
           System.out.println("Missing number :" +num[j]);
       }

    }

    private static int[] missingNum(int[] arrayA, int gap) {

        int[] num = new int[10];
        int j =0;
        for(int i=0; i<arrayA.length-1; i++){


                num[j] = arrayA[i];
               int tmp = arrayA[i];
                while(arrayA[i+1]-num[j] != gap){

                    num[j+1] = tmp + 2;

                    if((arrayA[i+1] - num[j+1]) == gap){
                        break;
                    }

                    tmp = num[j+1];

                    j++;
                }

        }

        return num;
    }

}

class MedianOfSortedArrays{



    public static void main(String[] args) {
        int[] arrayA = {1,2,3,4,5,7};
        int[] arrayB = {6,7,8,9,10,99};

        int cntA = arrayA.length;
        int cntB = arrayB.length;

        if(cntA != cntB){
            System.out.println("Array length are not equal");
        }

        findSumMedians(arrayA, arrayB);
    }

    private static void findSumMedians(int[] arrayA, int[] arrayB) {

        int medianA = arrayA.length/2;
        int medianB = arrayB.length/2;

        int sum = arrayA[medianA] + arrayB[medianB];

        System.out.println("Median Sum: "+sum/2);

    }

}

class KthElementInSortMergedTwoArrays {


    public static void main(String[] args) {

        int[] arrA = {1, 2, 3, 4, 7, 55};
        int[] arrB = {6, 7, 8, 9};
        int m = arrA.length;
        int n = arrB.length;
        int[] sortedArr = new int[m + n];

        int i = 0, j = 0, d = 0;

        while (i < m && j < n) {

            if (arrA[i] < arrB[j]) {
                sortedArr[d++] = arrA[i++];
            } else if (arrA[i] == arrB[j]) {
                sortedArr[d++] = arrA[i++];
                sortedArr[d++] = arrB[j++];
            } else if (arrA[i] > arrB[j]) {
                sortedArr[d++] = arrB[j++];
            }
        }

        while (i < m) {
            sortedArr[d++] = arrA[i++];
        }

        while (j < n) {
            sortedArr[d++] = arrB[j++];
        }


        for (int l = 0; l < (m + n); l++) {
            System.out.print(sortedArr[l] + " ");
        }
        System.out.println("");
        int l = 0;
        while (l < (m + n)) {

            System.out.print(sortedArr[l++] + " ");
        }

        System.out.println("");


    }


}

