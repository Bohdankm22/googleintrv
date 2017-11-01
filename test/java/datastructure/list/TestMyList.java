package datastructure.list;

import datastructure.exceptions.NoElementAtPositionException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
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
}
