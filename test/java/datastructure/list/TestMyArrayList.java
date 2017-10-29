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
        assertEquals("Could not add element.", true, test.add(testArg));
    }

    @Test
    public void testAddIntegerInput() {
        MyArrayList<Integer> test = new MyArrayList<>();
        int testArg = Integer.MAX_VALUE;
        assertEquals("Could not add element.", true, test.add(testArg));
    }

    @Test
    public void testGetStringInput() {
        MyArrayList<String> test = new MyArrayList<>();
        String testArg = "test";
        assertEquals("Could not add element.", true, test.add(testArg));
        assertEquals("Could not get element that was added.", testArg, test.get());
    }

    @Test
    public void testGetIntegerInput() {
        MyArrayList<Integer> test = new MyArrayList<>();
        int testArg = Integer.MAX_VALUE;
        assertEquals("Could not add element.", true, test.add(testArg));
        int result = test.get();
        assertEquals("Could not get element that was added.", testArg, result);
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
        assertEquals("Could not add element.", true, test.add(testArg));
        assertEquals("Could not get element that was added.", testArg, test.get(position));
    }

    @Test
    public void testGetByPositionIntegerInput() {
        MyArrayList<Integer> test = new MyArrayList<>();
        int testArg = Integer.MAX_VALUE;
        int position = 0;
        assertEquals("Could not add element.", true, test.add(testArg));
        int result = test.get(position);
        assertEquals("Could not get element that was added.", testArg, result);
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
        assertEquals("Could not add element.", true, test.add(testArg));
        assertNull("Getting element from empty list should return exception!", test.get(position));
    }

    @Test
    public void checkArraySize() {
        MyArrayList<Integer> test = new MyArrayList<>();
        int initialSize = 0;
        assertEquals("Size of empty list is not right!", initialSize, test.size());
        for (int i = 0; i < 100; i++) {
            test.add(1);
            assertEquals("Size after adding is not right!", i + 1, test.size());
        }
        for (int i = 99; i >= 0; i--) {
            test.remove();
            assertEquals("Size after removing is not right!", i, test.size());
        }
    }

    @Test
    public void testRemoveElemFromList() {
        MyArrayList<Integer> test = new MyArrayList<>();
        int testArg = Integer.MAX_VALUE;
        int position = 0;
        assertEquals("Could not add element.", true, test.add(testArg));
        int result = test.remove(position);
        assertEquals("Could not remove element that was added.", testArg, result);
        assertEquals("Size after removing is not right!", 0, test.size());
    }

    @Test(expected = NoElementAtPositionException.class)
    public void testRemoveByPositionFromEmptyList() {
        MyArrayList<Integer> test = new MyArrayList<>();
        int position = 0;
        assertNull("Getting element from empty list should return exception!", test.get(position));
    }
}
