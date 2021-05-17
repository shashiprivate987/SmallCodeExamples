package com.projects.learning.generics;

public class MyGen<T> {

    T obj;

    public void add(T obj){this.obj = obj;}

    public T getObj() {
        return obj;
    }
}
