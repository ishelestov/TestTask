

import java.util.*;

/**
 * Created by vanya on 14.04.15.
 */
public class MyHashMap {
    public static final int SIZE = 10;
    private int size;
    private Entry[] table;
    public MyHashMap() {
        this.size = SIZE;
        this.table = new Entry[size];
    }


    public int size() {
        return size;
    }


    public Object get(Object key) {
        return null;
    }


    public Object put(Object key, Object value) {
        int keyHash = key.hashCode();
//        int i = indexFor(hash, table.length);
        return null;
    }
    //    static int hash(int h)
//    {
//        h ^= (h >>> 20) ^ (h >>> 12);
//        return h ^ (h >>> 7) ^ (h >>> 4);
//    }
    private static int hash(Object x, int length) {
        int h = System.identityHashCode(x);
        // Multiply by -127, and left-shift to use least bit as part of hash
        return ((h << 1) - (h << 8)) & (length - 1);
    }
    public boolean push(Integer key, long value) {
//        int hash = key.hashCode();
        int hash = hash(key,size);
        int i=0;
        try{
            if (table[hash]==null ) {
                table[hash] = new Entry(key, value);
                return true;
            }
            for (i = hash + 1; i != hash; i = (i + 1) % table.length) {
//                for (Entry t:table){
//                    if (t.getKey() == key){
//                        System.out.printf("Key: %d was used earlier; Value =  %l ",key,value);
//                    }
//                }

                if (table[i]==null ) {
                    table[i] = new Entry(key, value);
                    return true;
                }else if (table[i].getKey() == key){
                    System.out.println("Used earlier");
                }

            }
            return false;
        } catch(NullPointerException e) {
//            table[hash] = new Entry(key, value);
            return true;
        }
    }


    static class Entry
    {
        final int key;
        Object value;
//        Entry next;
//        final int hash;

        public Entry(int key, Object value) {
            this.key = key;
            this.value = value;
        }

//        public Entry(int key, int hash, long value, Entry next) {
//            this.key = key;
//            this.hash = hash;
//            this.value = value;
//            this.next = next;
//        }
//        public final int hashCode() {
//            return Objects.hashCode(key) ^ Objects.hashCode(value);
//        }

        public Object getKey() {
            return key;
        }


        public Object getValue() {
            return value;
        }


        public Object setValue(Object value) {
            this.value = value;
            return value;
        }
    }
}

