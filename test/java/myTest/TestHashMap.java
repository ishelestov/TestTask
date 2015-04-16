package myTest;

import myTest.exception.ApplicationException;

import myTest.exception.KeyNotFoundException;
import myTest.exception.NoFreeCellsException;
import myTest.exception.NullKeyException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestHashMap {

    private MyHashMap myHashMap;

    @Before
    public void setUp() throws ApplicationException {
        myHashMap = new MyHashMap();
        myHashMap.put(10, 22132);
        myHashMap.put(15, 22132);
    }

    @Test
    public void testPutFunc() throws ApplicationException {
        boolean res = myHashMap.put(2,22132);
        Assert.assertTrue(res);
    }

    @Test
    public void testGetSize(){
        int res = myHashMap.size();
        Assert.assertNotNull(res);
    }

    @Test
    public void testFindByKey() throws ApplicationException {
        Object res = myHashMap.get(10);
        Assert.assertNotNull(res);
    }

    @Test(expected = KeyNotFoundException.class)
    public void testNonexistentKey() throws ApplicationException {
        myHashMap.get(102);
    }

    @Test(expected = NullKeyException.class)
    public void testPutNullKey() throws ApplicationException {
        myHashMap.put(null,1334);
    }

    @Test(expected = NullKeyException.class)
    public void testGetNullKey() throws ApplicationException {
        myHashMap.get(null);
    }

    @Test
    public void testMinusKey() throws ApplicationException {
        boolean res = myHashMap.put(-5, 3453);
        Assert.assertTrue(res);
    }
    @Test
    public void testMinusValue() throws ApplicationException {
        boolean res = myHashMap.put(5, -3453);
        Assert.assertTrue(res);
    }

    @Test(expected = NoFreeCellsException.class)
    public void testMoreElementThanSize() throws ApplicationException {
        for (int i = 0; i<15; i++){
            myHashMap.put(i, i*i);
        }

    }
    @Test
    public void testPutAtExistentKey() throws ApplicationException {
        boolean res = myHashMap.put(10, -3453);
        Assert.assertFalse(res);
    }


}
