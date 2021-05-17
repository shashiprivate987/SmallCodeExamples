package com.projects.learning.designpatterns.builder;

public class ComputerConf {

    // required parameters
    private String hdd;
    private String ram;

    // optional parameters
    private boolean isGraphicsCardEnabled;
    private boolean isBluetoothEnabled;

    public String getRAM(){
        return ram;
    }

    public String getHDD(){
        return hdd;
    }

    public boolean isGraphicsCardEnabled(){
        return this.isGraphicsCardEnabled;
    }

    public boolean isBluetoothEnabled(){
        return this.isBluetoothEnabled;
    }

    public ComputerConf(ComputerBuilder builder) {
        this.hdd=builder.HDD;
        this.ram=builder.RAM;
        this.isGraphicsCardEnabled=builder.isGraphicsCardEnabled;
        this.isBluetoothEnabled=builder.isBluetoothEnabled;
    }

    @Override
    public String toString() {
        return "Details: RAM: "+ getRAM()+ ", HDD: "+getHDD()+", Graphics Card ?:"+ isGraphicsCardEnabled()+", Bluetooth: :"+isBluetoothEnabled();
    }

    public  static  class ComputerBuilder{
        // required parameters
        private String HDD;
        private String RAM;

        // optional parameters
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;


        public ComputerBuilder(String HDD, String RAM){

            this.HDD = HDD;
            this.RAM = RAM;

        }

        public ComputerBuilder setGraphicsCardEnabled(boolean GraphicsCardEnabled){

                this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }


        public ComputerBuilder setBluetoothEnabled(boolean bluetoothEnabled) {
            this.isBluetoothEnabled = bluetoothEnabled;
            return this;
        }

        public ComputerConf build(){
            return new ComputerConf(this);
        }
    }

}

