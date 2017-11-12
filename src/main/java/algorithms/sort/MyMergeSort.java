package algorithms.sort;

import datastructure.list.MyList;

/**
 * Merge sort is an efficient, general-purpose, comparison-based sorting algorithm.
 * Worst case scenario O(n*log(n)).
 * Best case scenario O(n*log(n)).
 * Average case scenario O(n*log(n)).
 * Memory (auxiliary space) O(n).
 */
public class MyMergeSort<T extends Comparable<T>> implements Sortable<T> {

    @Override
    public MyList<T> sort(MyList<T> list) {
        return null;
    }

    @Override
    public String toString() {
        return "MyMergeSort";
    }
}
