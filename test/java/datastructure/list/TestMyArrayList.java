package datastructure.list;

import datastructure.exceptions.NoElementAtPositionException;
import datastructure.exceptions.NotAccessiblePositionException;
import org.junit.Test;

import static org.junit.Assert.*;

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

    @Test
    public void testRemoveByPositionList() {
        MyArrayList<Integer> test = new MyArrayList<>();
        for (int i = 0; i < 100; i++) {
            test.add(i);
        }
        for (int i = 50; i < 60; i++) {
            int removedItem = test.remove(i);
            int actualValue = test.get(i);
            assertNotEquals("Removed element should not be in the list!", removedItem, actualValue);

        }
        while (test.size() - 1 > 0) {
            int removedItem = test.remove(0);
            int actualValue = test.get(0);
            assertNotEquals("Removed element should not be in the list!", removedItem, actualValue);
        }
    }

    @Test
    public void testElementsPositionsOnTheList() {
        MyArrayList<Integer> test = new MyArrayList<>();
        int[] elements = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int addedElem = 6;
        for (int i : elements) {
            if (i != addedElem) {
                test.add(i);
            }
        }

        for (int i = 0; i < 6; i++) {
            int actValue = test.get(i);
            assertEquals("Element is not in place!", elements[i], actValue);
        }

        for (int i = 7; i < elements.length; i++) {
            int actValue = test.get(i - 1);
            assertEquals("Element is not in place!", elements[i], actValue);
        }

        test.remove();
    }

    @Test
    public void testCapacity() {
        MyArrayList<Integer> test = new MyArrayList<>();
        int initCapacity = 16;
        for (int i = 0; i < 9; i++) {
            assertEquals("Element is not in place!", initCapacity, test.capacity());
            test.add(i);
        }
        assertEquals("Element is not in place!", Math.round(initCapacity * 1.5), test.capacity());
    }

    @Test
    public void testIsEmpty() {
        MyArrayList<Integer> test = new MyArrayList<>();
        assertEquals("Element is not in place!", true, test.isEmpty());
        for (int i = 0; i < 5; i++) {
            test.add(0);
            assertEquals("Element is not in place!", false, test.isEmpty());
            test.remove();
            assertEquals("Element is not in place!", true, test.isEmpty());
        }
    }

    @Test(expected = NotAccessiblePositionException.class)
    public void testAddItemToWrongPosition() {
        MyArrayList<Integer> test = new MyArrayList<>();
        int testArg = Integer.MAX_VALUE;
        assertEquals("Should be not able to add elem to this position.", true, test.add(1, testArg));
    }

    @Test(expected = NotAccessiblePositionException.class)
    public void testAddItemToNegativePosition() {
        MyArrayList<Integer> test = new MyArrayList<>();
        int testArg = Integer.MAX_VALUE;
        assertEquals("Should be not able to add elem to this position.", true, test.add(-1, testArg));
    }

    @Test
    public void testAddItemWithPositioning() {
        MyArrayList<Integer> test = new MyArrayList<>();
        for (int i = 0; i < 20; i++) {
            assertEquals("Size of the list is not right.", i, test.size());
            test.add(0, i);
        }
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
}
