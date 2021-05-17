package com.projects.learning.designpatterns.factory;

public abstract class Computer {

    public abstract String getRAM();
    public abstract String getHDD();
    public  abstract String getCPU();


    @Override
    public String toString() {
        //return "get ram: "+ this.getRAM() +", get hdd: "+this.getHDD()+", get cpu: "+this.getCPU()+ " .";
        return "RAM= "+this.getRAM()+", HDD="+this.getHDD()+", CPU="+this.getCPU();
    }
}
