package algorithms.sort;

import datastructure.list.MyArrayList;
import datastructure.list.MyLinkedList;
import datastructure.list.MyList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class TestMySort {

    private MyList<Integer> list;
    private Sortable<Integer> sort;
    private int size;

    public TestMySort(Sortable<Integer> sort, MyList<Integer> list, int size) {
        this.sort = sort;
        this.list = list;
        this.size = size;
    }

    @Parameterized.Parameters(name = "{index}: test sorting {0} and list implementation {1} with size {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new MyInsertionSort<Integer>(), new MyArrayList<Integer>(), 100},
                {new MyInsertionSort<Integer>(), new MyArrayList<Integer>(), 101},
                {new MyInsertionSort<Integer>(), new MyArrayList<Integer>(), 10000},
                {new MyInsertionSort<Integer>(), new MyLinkedList<Integer>(), 100},
                {new MySelectionSort<Integer>(), new MyArrayList<Integer>(), 100},
                {new MySelectionSort<Integer>(), new MyArrayList<Integer>(), 101},
                {new MySelectionSort<Integer>(), new MyArrayList<Integer>(), 10000},
                {new MySelectionSort<Integer>(), new MyLinkedList<Integer>(), 100},
                {new MyMergeSort<Integer>(), new MyArrayList<Integer>(), 100},
                {new MyMergeSort<Integer>(), new MyArrayList<Integer>(), 101},
                {new MyMergeSort<Integer>(), new MyArrayList<Integer>(), 10000},
                {new MyMergeSort<Integer>(), new MyLinkedList<Integer>(), 100}
//                {new MyHeapSort<Integer>(), new MyArrayList<Integer>(), 100},
//                {new MyHeapSort<Integer>(), new MyArrayList<Integer>(), 10000},
//                {new MyHeapSort<Integer>(), new MyLinkedList<Integer>(), 100}
        });
    }

    @Before
    public void executePrerequisites() {
        list.removeAll();
    }

    @Test
    public void testReorderBackOrder() {
        for (int i = size; i >= 0; i--) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        MyList<Integer> sortedList = sort.sort(list);
        System.out.printf("Sorting took %d milliseconds.", (System.nanoTime() - startTime) / 1000000);
        for (int i = 0; i <= size; i++) {
            int result = sortedList.get(i);
            assertEquals(result, i);
        }
    }

    @Test
    public void testSortListWithSameValues() {
        for (int i = size; i >= 0; i--) {
            list.add(1);
        }
        long startTime = System.nanoTime();
        MyList<Integer> sortedList = sort.sort(list);
        System.out.printf("Sorting took %d milliseconds.", (System.nanoTime() - startTime) / 1000000);
        for (int i = 0; i <= size; i++) {
            int result = sortedList.get(i);
            assertEquals(result, 1);
        }
    }

    @Test
    public void testSortOrdered() {
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        MyList<Integer> sortedList = sort.sort(list);
        System.out.printf("Sorting took %d milliseconds.", (System.nanoTime() - startTime) / 1000000);
        for (int i = 0; i < size; i++) {
            int result = sortedList.get(i);
            assertEquals(result, i);
        }
    }

    @Test
    public void checkSizeAfterSort() {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(size));
        }
        assertEquals(list.size(), size);
        long startTime = System.nanoTime();
        MyList<Integer> sortedList = sort.sort(list);
        System.out.printf("Sorting took %d milliseconds.", (System.nanoTime() - startTime) / 1000000);
        assertEquals(sortedList.size(), size);
    }
}