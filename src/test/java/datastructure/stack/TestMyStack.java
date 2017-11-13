package datastructure.stack;

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
public class TestMyStack {

    private MyStack<Integer> stack;

    public TestMyStack(MyStack<Integer> stack) {
        this.stack = stack;
    }

    @Parameterized.Parameters(name = "{index}: test stack {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new MyLinkedList<Integer>()}
        });
    }

    @Before
    public void executePrerequisites() {
        stack.removeAll();
    }

    @Test
    public void testEmpty() {
        assertEquals(true, stack.isEmpty());
        stack.push(Integer.MAX_VALUE);
        assertEquals(false, stack.isEmpty());
    }

    @Test
    public void testEnqueueIntegerInput() {
        int testArg = Integer.MAX_VALUE;
        assertEquals(true, stack.push(testArg));
    }

    @Test
    public void testDequeueIntegerInput() {
        int testArg = Integer.MAX_VALUE;
        stack.push(testArg);
        int result = stack.pop();
        assertEquals(testArg, result);
        for (int i = 0; i <= 100; i++) {
            stack.push(i);
        }
        for (int i = 100; i >= 0; i--) {
            result = stack.pop();
            assertEquals(i, result);
        }
    }

    @Test
    public void testSize() {
        assertEquals(0, stack.size());
        stack.push(Integer.MAX_VALUE);
        assertEquals(1, stack.size());
        stack.pop();
        assertEquals(0, stack.size());
        for (int i = 0; i < 100; i++) {
            stack.push(1);
            Assert.assertEquals("Size after adding is not right!", i + 1, stack.size());
        }
        for (int i = 99; i >= 0; i--) {
            stack.pop();
            Assert.assertEquals("Size after removing is not right!", i, stack.size());
        }
    }
}