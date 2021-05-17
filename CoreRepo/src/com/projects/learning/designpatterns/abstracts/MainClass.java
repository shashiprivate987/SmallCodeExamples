package com.projects.learning.designpatterns.abstracts;

public class MainClass {

    public static void main(String[] args) {

        OSFactory factory = new OSFactory();

        OS android = factory.selectOS("android");
        android.installOS();

        OS mac = factory.selectOS("mac");
        mac.installOS();
    }
}
