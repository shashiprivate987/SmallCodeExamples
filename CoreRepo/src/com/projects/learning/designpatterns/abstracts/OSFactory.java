package com.projects.learning.designpatterns.abstracts;

public class OSFactory {

    public OS selectOS(String osType){

        if(osType.equalsIgnoreCase("android")){
            return new Android();
        }else if (osType.equalsIgnoreCase("mac")){
            return new Mac();
        }

        return  null;

    }

}
