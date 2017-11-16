package datastructure.tree;

import datastructure.map.MyBinaryTreeMap;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

@RunWith(value = Parameterized.class)
public class TestMyTree {

    private ITree<Integer> tree;

    public TestMyTree(ITree<Integer> tree) {
        this.tree = tree;
    }

    @Parameterized.Parameters(name = "{index}: test tree {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new MyBinaryTreeMap<Integer, String>()},
        });
    }

    @Before
    public void executePrerequisites() {
        tree.removeAll();
    }

    @Test
    public void testGetMax() {
        int[] array = {21, 22, 33, 4, 2892, 154, 1, 122};
        for (int i = 0; i < array.length; i++) {
            tree.put(array[i]);
        }
        int result = tree.getMax();
        assertEquals(2892, result);
    }

    @Test
    public void testGetMin() {
        int[] array = {21, 22, 33, 4, 2892, 154, 1, 122};
        for (int i = 0; i < array.length; i++) {
            tree.put(array[i]);
        }
        int result = tree.getMin();
        assertEquals(1, result);
    }
}
