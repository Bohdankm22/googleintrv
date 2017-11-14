package datastructure.tree;

import algorithms.sort.MyInsertionSort;
import algorithms.sort.MyMergeSort;
import algorithms.sort.MySelectionSort;
import algorithms.sort.Sortable;
import datastructure.list.MyArrayList;
import datastructure.list.MyLinkedList;
import datastructure.list.MyList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

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
    public void testSize() {

    }

}
