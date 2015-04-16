package myTest;

import myTest.exception.ApplicationException;


public class TestMain {
    public static void main(String[] args) throws ApplicationException {
        MyHashMap myHashMap = new MyHashMap();

        myHashMap.put(-1, 111);
        myHashMap.put(9, 222);
        myHashMap.put(29, 333);
        myHashMap.put(21, 338);
        myHashMap.put(77, 0);
        myHashMap.put(13, 111);
        myHashMap.put(29, 222);
        myHashMap.put(239, 333);
        myHashMap.put(221, 338);
        myHashMap.put(231, 338);
//            myHashMap.put(723,444);


        System.out.println(myHashMap.get(-1));
        System.out.println(myHashMap.get(77));
        System.out.println(myHashMap.get(21));
        System.out.println(myHashMap.get(231));
        System.out.println("size = "+myHashMap.size());





    }
}
