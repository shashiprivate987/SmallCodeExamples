package com.projects.learning.generics;

public class TestGenerics3 {


    public static void main(String[] args) {

        MyGen<Integer> gen = new MyGen<Integer>();
        gen.add(10);

        System.out.println("Value: "+gen.getObj());
    }
}
