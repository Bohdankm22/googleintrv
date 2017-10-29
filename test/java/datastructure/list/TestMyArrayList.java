package datastructure.list;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMyArrayList {

    @Test
    public void testStringInput() {
        MyArrayList<String> test = new MyArrayList<>();
        String testArg = "test";
        assertEquals("Simple check should be equals", test.add(testArg), true);
    }

    @Test
    public void testIntegerInput() {
        MyArrayList<Integer> test = new MyArrayList<>();
        int testArg = Integer.MAX_VALUE;
        assertEquals("Simple check should be equals", test.add(testArg), true);
    }

}
