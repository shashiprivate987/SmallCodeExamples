package com.projects.learning.designpatterns.JavaDesignPatterns;

public class SingletonEveryDayDemo {

    public static void main(String[] args) {
        Runtime singleTonRunTime = Runtime.getRuntime();

        System.out.println(singleTonRunTime);

        Runtime anotherInstance = Runtime.getRuntime();
        System.out.println(anotherInstance);

        if(singleTonRunTime == anotherInstance)
            System.out.println("Both are same instance..");
    }

}
