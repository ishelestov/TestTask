package myTest;

/**
 * Created by vanya on 14.04.15.
 */
public class Main {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(13, 111);
        myHashMap.put(2, 222);
        myHashMap.put(4, 333);
        myHashMap.put(3,444);
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(2));
        System.out.println(myHashMap.get(3));
        System.out.println(myHashMap.get(4));





    }
}
