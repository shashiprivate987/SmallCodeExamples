package com.projects.learning.designpatterns.factory;

public class TestFactory {

    public static void main(String[] args) {

         Computer pc = ComputerFactory.getComputer("pc","100", "200", "150");

        System.out.println("My PC has config of :"+ pc);

    }
}
