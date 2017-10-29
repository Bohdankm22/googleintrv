package datastructure.list;

import datastructure.exceptions.NoElementAtPositionException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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

    @Test(expected = NoElementAtPositionException.class)
    public void testGetFromEmptyList() {
        MyArrayList<Integer> test = new MyArrayList<>();
        assertNull("Getting element from empty list should return exception!", test.get());
    }

    @Test
    public void testGetByPositionStringInput() {
        MyArrayList<String> test = new MyArrayList<>();
        String testArg = "test";
        int position = 0;
        assertEquals("Could not add element.", test.add(testArg), true);
        assertEquals("Could not get element that was added.", test.get(position), testArg);
    }

    @Test
    public void testGetByPositionIntegerInput() {
        MyArrayList<Integer> test = new MyArrayList<>();
        int testArg = Integer.MAX_VALUE;
        int position = 0;
        assertEquals("Could not add element.", test.add(testArg), true);
        int result = test.get(position);
        assertEquals("Could not get element that was added.", result, testArg);
    }

    @Test(expected = NoElementAtPositionException.class)
    public void testGetByPositionFromEmptyList() {
        MyArrayList<Integer> test = new MyArrayList<>();
        int position = 0;
        assertNull("Getting element from empty list should return exception!", test.get(position));
    }

    @Test(expected = NoElementAtPositionException.class)
    public void testGetByNegativePositionFromEmptyList() {
        MyArrayList<Integer> test = new MyArrayList<>();
        int position = -1;
        assertNull("Getting element from empty list should return exception!", test.get(position));
    }

    @Test(expected = NoElementAtPositionException.class)
    public void testGetByWrongPositionFromEmptyList() {
        MyArrayList<Integer> test = new MyArrayList<>();
        int testArg = Integer.MAX_VALUE;
        int position = 1;
        assertEquals("Could not add element.", test.add(testArg), true);
        assertNull("Getting element from empty list should return exception!", test.get(position));
    }

}
