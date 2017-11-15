package datastructure.map;

import algorithms.sort.MyMergeSort;
import datastructure.list.MyArrayList;
import datastructure.list.MyList;
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
public class TestMyMap {

    private IMyMap<Integer, String> tree;

    public TestMyMap(IMyMap<Integer, String> tree) {
        this.tree = tree;
    }

    @Parameterized.Parameters(name = "{index}: test map {0}")
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
    public void testSizeOfEmptyMap() {
        assertEquals(0, tree.size());
    }

    @Test
    public void testEmptyMap() {
        assertTrue(tree.empty());
    }

    @Test
    public void testPutToMap() {
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

    @Test
    public void testKeyList() {
        int[] array = {21, 22, 33, 4, 2892, 154, 1, 122};
        MyList<Integer> list = new MyArrayList<>();
        for (int i = 0; i < array.length; i++) {
            tree.put(array[i], "");
            list.add(array[i]);
        }
        list = new MyMergeSort<Integer>().sort(list);
        assertEquals(list, tree.getKeyList());
    }
}
