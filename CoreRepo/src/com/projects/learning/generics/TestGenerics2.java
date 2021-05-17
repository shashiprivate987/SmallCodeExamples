package com.projects.learning.generics;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestGenerics2 {

    public static void main(String[] args){


        Map<Integer,String> map = new HashMap<Integer,String>();
        map.put(1,"shashi");
        map.put(2,"raj");


        Set<Map.Entry<Integer,String>> set = map.entrySet();

        Iterator<Map.Entry<Integer,String>> itr = set.iterator();

        while(itr.hasNext()){
            Map.Entry e = itr.next();
            System.out.println("Key: "+e.getKey()+" and "+"Value: "+e.getValue());
        }
    }
}
