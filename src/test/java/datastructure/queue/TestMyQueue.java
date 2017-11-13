package datastructure.queue;

import datastructure.list.MyLinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

@RunWith(value = Parameterized.class)
public class TestMyQueue {

    private MyQueue<Integer> queue;

    public TestMyQueue(MyQueue<Integer> queue) {
        this.queue = queue;
    }

    @Parameterized.Parameters(name = "{index}: test queue {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new MyLinkedList<Integer>()}
        });
    }

    @Before
    public void executePrerequisites() {
        queue.removeAll();
    }

    @Test
    public void testEmpty() {
        assertEquals("Could not add element.", true, queue.isEmpty());
        queue.enqueue(Integer.MAX_VALUE);
        assertEquals("Could not add element.", false, queue.isEmpty());
    }

    @Test
    public void testEnqueueIntegerInput() {
        int testArg = Integer.MAX_VALUE;
        assertEquals("Could not add element.", true, queue.enqueue(testArg));
    }

    @Test
    public void testDequeueIntegerInput() {
        int testArg = Integer.MAX_VALUE;
        queue.enqueue(testArg);
        int result = queue.dequeue();
        assertEquals("Could not add element.", testArg, result);
        for (int i = 0; i < 100; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 100; i++) {
            result = queue.dequeue();
            assertEquals("Could not add element.", i, result);
        }
    }

    @Test
    public void testSize() {
        assertEquals("Could not add element.", 0, queue.size());
        queue.enqueue(Integer.MAX_VALUE);
        assertEquals("Could not add element.", 1, queue.size());
        queue.dequeue();
        assertEquals("Could not add element.", 0, queue.size());
        for (int i = 0; i < 100; i++) {
            queue.enqueue(1);
            Assert.assertEquals("Size after adding is not right!", i + 1, queue.size());
        }
        for (int i = 99; i >= 0; i--) {
            queue.dequeue();
            Assert.assertEquals("Size after removing is not right!", i, queue.size());
        }
    }
}
