package myTest;

import myTest.exception.ApplicationException;
import myTest.exception.KeyNotFoundException;
import myTest.exception.NoFreeCellsException;
import myTest.exception.NullKeyException;


public class MyHashMap {
    // For correct working with big data, we should use flexible size, that
    // change if it necessary
    public static final int SIZE = 10;
    // Amount of added elements
    private int size;
    private Entry[] table;
    // Empty constructor, that initialized size and table of Entries(key,value)
    public MyHashMap() {
        this.size = 0;
        this.table = new Entry[SIZE];
    }

    /**
     * @return amount of added elements
     */
    public int size() {
        return size;
    }

    /**
     * Adding pair of key(Integer)&value(Long) to our map
     * @param key for insert element
     * @return true if inserted element is new, otherwise false
     */
    public boolean put(Integer key, long value) throws ApplicationException {
        if (size == SIZE){
            throw new NoFreeCellsException("No free cells; Increas the size of table");
        }

        int hash;
        if (key == null){
            throw new NullKeyException("This map don't support null key");
        }else {
            //Take modulo from hashCode of our value to fit in table of this size
            //Take module hash to support minus values
            hash = Math.abs(key.hashCode() % SIZE);
        }
        int i = 0;
        //If cell empty - put new pair of key&value
        if (table[hash]==null ) {
            table[hash] = new Entry(key, value);
            size++;
            return true;
        }
        //If this key is used - change value at this key
        if (table[hash].getKey()==key){
            table[hash].setValue(value);
            size++;
            return false;
        }
        //If cell is not free - found nearest empty cell
        for (i = hash + 1; i != hash; i++) {
            //If end of table - start over
            if (i>=SIZE){
                i = 0;
            }
            //If cell empty - put new pair of key&value
            if (table[i]==null ) {
                table[i] = new Entry(key, value);
                size++;
                return true;
            }

        }
        return false;
    }

    /**
     * Get Long type value by Integer key
     * @param key for find element
     * @return Long type value
     */

    public Long get(Integer key) throws ApplicationException {
        // Check for null key
        if (key == null) {
            throw new NullKeyException("This map don't support null key");
        }
        //Take module hash to support minus values
        int hash = Math.abs(key.hashCode() % SIZE);

        if (table[hash]!=null){
            if (table[hash].getKey() == key) {
                return table[hash].getValue();
            }
            //If you have few values for one hash - function find nearest empty cell
            for (int i = hash + 1; i != hash; i ++) {
                //If end of table - start over
                if (i>=SIZE){
                    i = 0;
                }
                if (table[i]!=null && table[i].getKey().equals(key)){
                    return table[i].getValue();
                }
                if (i==hash-1){
                    throw new KeyNotFoundException("Not found this key;");
                }
            }
        }else {
            throw new KeyNotFoundException("Not found this key;");
        }

        return null;

    }
    /**
     * Class for make pair of key&value
     * @param key - int
     * @param value - long
     */

    static class Entry
    {
        final int key;
        long value;
        public Entry(int key, long value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public long getValue() {
            return value;
        }

        public Long setValue(long value) {
            this.value = value;
            return value;
        }

    }
}

