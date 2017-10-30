package datastructure.list;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMyLinkedList {

    @Test
    public void testEmptySize() {
        MyLinkedList<Integer> test = new MyLinkedList<>();
        assertEquals("The list should be empty.", true, test.empty());
        assertEquals("The list should have 0 elements.", 0, test.size());
    }
}
