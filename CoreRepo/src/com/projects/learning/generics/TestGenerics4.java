package com.projects.learning.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestGenerics4{

    public static < E > void printArray(E[] elements) {
        for ( E element : elements){
            System.out.println(element );
        }
        System.out.println();
    }
    public static void main( String args[] ) {
        Integer[] intArray = { 10, 20, 30, 40, 50 };
        Character[] charArray = { 'J', 'A', 'V', 'A', 'T','P','O','I','N','T' };

        System.out.println( "Printing Integer Array" );
        printArray( intArray  );

        System.out.println( "Printing Character Array" );
        printArray( charArray );


        List<String> l = new ArrayList<String>();
        Collection<String> l1 = new ArrayList<String>();

        //Collection<Object> l2 = new ArrayList<String>();


    }
}
