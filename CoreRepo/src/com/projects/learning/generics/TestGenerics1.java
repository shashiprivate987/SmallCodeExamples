package com.projects.learning.generics;

import java.util.ArrayList;
import java.util.Iterator;

public class TestGenerics1 {

    public static void main(String[] args){

        ArrayList<String> list = new ArrayList<String>();
        list.add("shashi");
        list.add("raj");

        String s = list.get(0);
        System.out.println("value: " + s);

        Iterator<String> itr = list.iterator();

        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
