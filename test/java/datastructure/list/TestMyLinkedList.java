package datastructure.list;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestMyLinkedList {

    @Test
    public void testEmptySize() {
        MyLinkedList<Integer> test = new MyLinkedList<>();
        assertEquals("The list should be empty.", true, test.empty());
        assertEquals("The list should have 0 elements.", 0, test.size());
    }

    @Test
    public void testAddElement() {
        MyLinkedList<Integer> test = new MyLinkedList<>();
        for (int i = 1; i < 100; i++) {
            test.add(i);
            assertEquals("The list should be empty.", false, test.empty());
            assertEquals("The list should have 0 elements.", i, test.size());
        }
    }

    @Test
    public void testGetElementByPosition() {
        MyLinkedList<Integer> test = new MyLinkedList<>();
        for (int i = 0; i < 100; i++) {
            test.add(i);
        }
        for (int i = 0; i < 100; i++) {
            int result = test.get(i);
            assertEquals("The element is not right.", i, result);
        }
    }

    @Test
    public void testAddFirst() {
        MyLinkedList<Integer> test = new MyLinkedList<>();
        for (int i = 0; i < 100; i++) {
            test.addFirst(i);
        }
        for (int i = 99, j = 0; i >= 0; i--, j++) {
            int result = test.get(j);
            assertEquals("The element is not right.", i, result);
        }
    }

    @Test
    public void testPopFirst() {
        MyLinkedList<Integer> test = new MyLinkedList<>();
        for (int i = 0; i < 100; i++) {
            test.addFirst(i);
        }
        for (int i = 99; i >= 0; i--) {
            int result = test.popFirst();
            assertEquals("The element is not right.", i, result);
        }
        assertEquals("The element is not right.", 0, test.size());
        assertNull("The element is not right.", test.popFirst());
    }
}
