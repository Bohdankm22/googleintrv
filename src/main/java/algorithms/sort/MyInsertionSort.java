package algorithms.sort;

import datastructure.list.MyList;

/**
 * Insertion sort is a simple sorting algorithm that builds the final sorted array (or list) one item at a time.
 * It is much less efficient on large lists than more advanced algorithms such as quicksort, heapsort, or merge sort.
 * Worst case scenario O(n^2).
 * Best case scenario O(n).
 * Average case scenario O(n^2).
 */
public class MyInsertionSort<T extends Comparable<T>> implements Sortable<T> {

    @Override
    public MyList<T> sort(MyList<T> list) {
        for (int i = 1; i < list.size(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    insert(list, i, j + 1);
                    break;
                }
                if (j == 0) {
                    insert(list, i, j);
                    break;
                }
            }
        }
        return list;
    }

    private boolean insert(MyList<T> list, int fromPosition, int toPosition) {
        if (fromPosition == toPosition) {
            return false;
        }
        return list.add(toPosition, list.remove(fromPosition));
    }

    @Override
    public String toString() {
        return "MyInsertionSort";
    }
}
