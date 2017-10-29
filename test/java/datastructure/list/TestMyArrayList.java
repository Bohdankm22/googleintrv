package datastructure.list;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMyArrayList {

    @Test
    public void testAddStringInput() {
        MyArrayList<String> test = new MyArrayList<>();
        String testArg = "test";
        assertEquals("Could not add element.", test.add(testArg), true);
    }

    @Test
    public void testAddIntegerInput() {
        MyArrayList<Integer> test = new MyArrayList<>();
        int testArg = Integer.MAX_VALUE;
        assertEquals("Could not add element.", test.add(testArg), true);
    }

    @Test
    public void testGetStringInput() {
        MyArrayList<String> test = new MyArrayList<>();
        String testArg = "test";
        assertEquals("Could not add element.", test.add(testArg), true);
        assertEquals("Could not get element that was added.", test.get(), testArg);
    }

    @Test
    public void testGetIntegerInput() {
        MyArrayList<Integer> test = new MyArrayList<>();
        int testArg = Integer.MAX_VALUE;
        assertEquals("Could not add element.", test.add(testArg), true);
        int result = test.get();
        assertEquals("Could not get element that was added.", result, testArg);
    }

}
