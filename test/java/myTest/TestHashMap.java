package myTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestHashMap {

    private MyHashMap myHashMap;

    @Before
    public void setUp(){
        myHashMap = new MyHashMap();
        boolean res = myHashMap.push(1,22132);
    }

    @Test
    public void testPutFunc(){
        boolean res = myHashMap.push(1,22132);
        Assert.assertTrue(res);
    }

    @Test(expected = NullPointerException.class)
    public void testNotFoundKey(){
        Object res = myHashMap.get(1);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testUncorrectSize(){
        Object res = myHashMap.get(15);
    }

}
