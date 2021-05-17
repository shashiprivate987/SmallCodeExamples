package com.projects.learning.generics;

public class Generics<T> {

    T obj;

    Generics(T obj){
        this.obj = obj;
    }

    public void show(){

        System.out.println("The type of object is: "+ obj.getClass().getCanonicalName());
    }

    public T getObj() {
        return obj;
    }
}


class Test {
    public static void main(String[] args) {
        Generics<String> g1 = new Generics<String>("Shashi");
        Generics<Integer> g2 = new Generics<Integer>(10);
        g1.show();
        System.out.println(g1.getObj());

        g2.show();
        System.out.println(g2.getObj());
    }
}
