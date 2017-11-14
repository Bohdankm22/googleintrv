package datastructure.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(value = Parameterized.class)
public class TestMyTree {

    private IMyTree<Integer, String> tree;

    public TestMyTree(IMyTree<Integer, String> tree) {
        this.tree = tree;
    }

    @Parameterized.Parameters(name = "{index}: test tree {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new MyBinaryTree<Integer, String>()},
        });
    }

    @Test
    public void testSizeOfEmptyTree() {
        assertEquals(0, tree.size());
    }

    @Test
    public void testEmptyTree() {
        assertTrue(tree.empty());
    }

}
