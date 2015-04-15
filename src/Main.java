

/**
 * Created by vanya on 14.04.15.
 */
public class Main {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.push(1,111);
        myHashMap.push(2,222);
        myHashMap.push(2,333);
        myHashMap.push(3,444);
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(2));
        System.out.println(myHashMap.get(3));





    }
}
