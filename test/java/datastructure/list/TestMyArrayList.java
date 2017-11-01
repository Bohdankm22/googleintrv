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
