package com.projects.learning.designpatterns.singleton;

public class DbSingletonDemo {

    public static void main(String[] args) {

        DbSingleton instance = DbSingleton.getInstance();
        System.out.println(instance);

        DbSingleton anotherInstance = DbSingleton.getInstance();
        System.out.println(anotherInstance);

        if(instance == anotherInstance)
            System.out.println("Both are same instances");


    }
}
