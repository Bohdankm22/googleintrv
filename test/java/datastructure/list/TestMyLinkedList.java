package datastructure.list;

import datastructure.exceptions.NotAccessiblePositionException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestMyLinkedList {

    @Test
    public void testEmptySize() {
        MyLinkedList<Integer> test = new MyLinkedList<>();
        assertEquals("The list should be isEmpty.", true, test.isEmpty());
        assertEquals("The list should have 0 elements.", 0, test.size());
    }

    @Test
    public void testAddElement() {
        MyLinkedList<Integer> test = new MyLinkedList<>();
        for (int i = 1; i < 100; i++) {
            test.add(i);
            assertEquals("The list should not be isEmpty.", false, test.isEmpty());
            assertEquals("The list should have proper size.", i, test.size());
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

    @Test
    public void testPop() {
        MyLinkedList<Integer> test = new MyLinkedList<>();
        for (int i = 0; i < 100; i++) {
            test.add(i);
        }
        for (int i = 99; i >= 0; i--) {
            int result = test.pop();
            assertEquals("The element is not right.", i, result);
        }
        assertEquals("The element is not right.", 0, test.size());
        assertNull("The element should be null.", test.pop());
    }

    @Test
    public void testGetFirst() {
        MyLinkedList<Integer> test = new MyLinkedList<>();
        assertNull(test.getFirst());
        for (int i = 0; i < 100; i++) {
            test.add(i);
        }
        int result = test.getFirst();
        assertEquals(0, result);
    }

    @Test
    public void testGetLast() {
        MyLinkedList<Integer> test = new MyLinkedList<>();
        assertNull(test.getFirst());
        for (int i = 0; i < 100; i++) {
            test.add(i);
        }
        int result = test.getLast();
        assertEquals(99, result);
    }

    @Test
    public void testAddAtPosition() {
        MyLinkedList<Integer> test = new MyLinkedList<>();
        for (int i = 0; i < 100; i++) {
            test.add(i);
        }
        test.add(45, 4444);
        int result = test.get(45);
        assertEquals(4444, result);
        test.add(76, 4444);
        result = test.get(76);
        assertEquals(4444, result);
        test.add(0, 4444);
        result = test.get(0);
        assertEquals(4444, result);
        test.add(100, 4444);
        result = test.get(100);
        assertEquals(4444, result);
    }

    @Test(expected = NotAccessiblePositionException.class)
    public void testAddAtNotValidPosition() {
        MyLinkedList<Integer> test = new MyLinkedList<>();
        test.add(-1, 1);
    }

    @Test(expected = NotAccessiblePositionException.class)
    public void testAddAtExceededPosition() {
        MyLinkedList<Integer> test = new MyLinkedList<>();
        test.add(1, 1);
    }

    @Test(expected = NotAccessiblePositionException.class)
    public void testAddAtWrongPosition() {
        MyLinkedList<Integer> test = new MyLinkedList<>();
        test.add(0);
        test.add(2, 1);
    }
}
