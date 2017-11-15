package datastructure.tree;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

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

    @Before
    public void executePrerequisites() {
        tree.removeAll();
    }

    @Test
    public void testSizeOfEmptyTree() {
        assertEquals(0, tree.size());
    }

    @Test
    public void testEmptyTree() {
        assertTrue(tree.empty());
    }

    @Test
    public void testPutToTree() {
        assertEquals(0, tree.size());
        tree.put(0, "Some");
        for (int i = 1; i < 100; i++) {
            assertEquals(i, tree.size());
            tree.put(i, "Something");
        }
    }

    @Test
    public void testContains() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int numb = random.nextInt(99999);
            tree.put(numb, "Something");
            assertTrue(tree.containsKey(numb));
        }
    }

    @Test
    public void testPuttingDuplicate() {
        tree.put(333, "Some");
        assertEquals(1, tree.size());
        for (int i = 0; i < 100; i++) {
            tree.put(333, "Something" + i);
            assertEquals(1, tree.size());
        }
    }
}
