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
    public void testGetStringInput() {
        MyArrayList<String> test = new MyArrayList<>();
        String testArg = "test";
        assertEquals("Could not add element.", true, test.add(testArg));
        assertEquals("Could not get element that was added.", testArg, test.get());
    }

    @Test
    public void testGetByPositionStringInput() {
        MyArrayList<String> test = new MyArrayList<>();
        String testArg = "test";
        int position = 0;
        assertEquals("Could not add element.", true, test.add(testArg));
        assertEquals("Could not get element that was added.", testArg, test.get(position));
    }

    @Test(expected = NoElementAtPositionException.class)
    public void testGetByWrongPositionFromEmptyList() {
        MyArrayList<Integer> test = new MyArrayList<>();
        int testArg = Integer.MAX_VALUE;
        int position = 1;
        assertEquals("Could not add element.", true, test.add(testArg));
        assertNull("Getting element from isEmpty list should return exception!", test.get(position));
    }

    @Test
    public void testCapacity() {
        MyArrayList<Integer> test = new MyArrayList<>();
        int capacity = 16;
        for (int i = 0; i < 16; i++) {
            assertEquals("Element is not in place!", capacity, test.capacity());
            test.add(i);
        }
        assertEquals("Element is not in place!", Math.round(capacity * 2), test.capacity());
        for (int i = 0; i < 8; i++) {
            test.remove();
        }
        assertEquals("Element is not in place!", capacity, test.capacity());
        for (int i = 0; i < 4; i++) {
            test.remove();
        }
        assertEquals("Element is not in place!", capacity / 2, test.capacity());
        for (int i = 0; i < 2; i++) {
            test.remove();
        }
        assertEquals("Element is not in place!", capacity / 4, test.capacity());
    }

    @Test
    public void testAddFirst() {
        MyArrayList<Integer> test = new MyArrayList<>();
        for (int i = 0; i < 20; i++) {
            assertEquals("Size of the list is not right.", i, test.size());
            test.addFirst(i);
            int result = test.getFirst();
            assertEquals("Element is not right.", i, result);
        }
    }

    @Test
    public void testFindNonExist() {
        MyArrayList<Integer> test = new MyArrayList<>();
        test.add(1);
        assertEquals("Element position should not be found.", -1, test.find(2));
    }

    @Test
    public void testFind() {
        MyArrayList<Integer> test = new MyArrayList<>();
        test.add(1);
        for (int i = 0; i < 10; i++) {
            assertEquals("Element expected at position", i, test.find(1));
            test.addFirst(2);
        }
    }

    @Test
    public void testFindWithMultiple() {
        MyArrayList<Integer> test = new MyArrayList<>();
        test.add(1);
        for (int i = 0; i < 10; i++) {
            assertEquals("Element expected at position", 0, test.find(1));
            test.addFirst(1);
        }
    }

    @Test
    public void testRemoveItem() {
        MyArrayList<Integer> test = new MyArrayList<>();
        Integer elem = 1;
        test.add(elem);
        boolean result = test.remove(elem);
        assertEquals("Element should be removed", true, result);
        assertEquals("Element should be removed", 0, test.size());
    }

    @Test
    public void testRemoveMultipleItem() {
        MyArrayList<Integer> test = new MyArrayList<>();
        Integer elem = 1;
        for (int i = 0; i < 100; i++) {
            test.add(elem);
        }
        assertEquals("List size is wrong", 100, test.size());
        boolean result = test.remove(elem);
        assertEquals("Elements should be removed", true, result);
        assertEquals("List size is wrong", 0, test.size());
    }
}
