package com.projects.learning.designpatterns.builder;

public class TestBuilderPattern {

    public static void main(String[] args) {
        ComputerConf comp = new ComputerConf.ComputerBuilder("500GB", "8GB").setBluetoothEnabled(true).build();
        System.out.println("my Comp: "+comp);
    }
}
