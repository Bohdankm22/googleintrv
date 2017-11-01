package datastructure.list;

import datastructure.exceptions.NoElementAtPositionException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

@RunWith(value = Parameterized.class)
public class TestMyList {

    private MyList<Integer> list;

    public TestMyList(MyList<Integer> list) {
        this.list = list;
    }

    @Parameterized.Parameters(name = "{index}: test list {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new MyArrayList<Integer>()}, {new MyLinkedList<Integer>()}
        });
    }

    @Before
    public void executePrerequisites() {
        list.removeAll();
    }

    @Test
    public void testAddIntegerInput() {
        int testArg = Integer.MAX_VALUE;
        assertEquals("Could not add element.", true, list.add(testArg));
    }

    @Test
    public void testGetIntegerInput() {
        int testArg = Integer.MAX_VALUE;
        assertEquals("Could not add element.", true, list.add(testArg));
        int result = list.get();
        assertEquals("Could not get element that was added.", testArg, result);
    }

    @Test(expected = NoElementAtPositionException.class)
    public void testGetFromEmptyList() {
        assertNull("Getting element from isEmpty list should return exception!", list.get());
    }

    @Test
    public void testGetByPositionIntegerInput() {
        int testArg = Integer.MAX_VALUE;
        int position = 0;
        assertEquals("Could not add element.", true, list.add(testArg));
        int result = list.get(position);
        assertEquals("Could not get element that was added.", testArg, result);
    }

    @Test(expected = NoElementAtPositionException.class)
    public void testGetByPositionFromEmptyList() {
        int position = 0;
        list.get(position);
    }

    @Test(expected = NoElementAtPositionException.class)
    public void testGetByNegativePositionFromEmptyList() {
        int position = -1;
        list.get(position);
    }

    @Test
    public void checkListSize() {
        int initialSize = 0;
        assertEquals("Size of empty list is not right!", initialSize, list.size());
        for (int i = 0; i < 100; i++) {
            list.add(1);
            assertEquals("Size after adding is not right!", i + 1, list.size());
        }
        for (int i = 99; i >= 0; i--) {
            list.remove();
            assertEquals("Size after removing is not right!", i, list.size());
        }
    }

    @Test
    public void testRemoveElemFromList() {
        int testArg = Integer.MAX_VALUE;
        int position = 0;
        assertEquals("Could not add element.", true, list.add(testArg));
        int result = list.remove(position);
        assertEquals("Could not remove element that was added.", testArg, result);
        assertEquals("Size after removing is not right!", 0, list.size());
    }

    @Test(expected = NoElementAtPositionException.class)
    public void testRemoveByPositionFromEmptyList() {
        int position = 0;
        list.get(position);
    }

    @Test
    public void testRemoveByPositionList() {
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        for (int i = 50; i < 60; i++) {
            int removedItem = list.remove(i);
            int actualValue = list.get(i);
            assertNotEquals("Removed element should not be in the list!", removedItem, actualValue);

        }
        while (list.size() - 1 > 0) {
            int removedItem = list.remove(0);
            int actualValue = list.get(0);
            assertNotEquals("Removed element should not be in the list!", removedItem, actualValue);
        }
    }
}
