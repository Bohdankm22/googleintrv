package algorithms.sort;

import datastructure.list.MyArrayList;
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
        if (list.size() <= 1) {
            return list;
        }
        return sort(list.sublist(list.size() / 2), list.sublist(list.size() / 2, list.size() - list.size() / 2));
    }

    private MyList<T> sort(MyList<T> listLeft, MyList<T> listRight) {
        MyList<T> left = listLeft.size() <= 1 ? listLeft : sort(listLeft.sublist(listLeft.size() / 2),
                listLeft.sublist(listLeft.size() / 2, listLeft.size() - listLeft.size() / 2));
        MyList<T> right = listRight.size() <= 1 ? listRight : sort(listRight.sublist(listRight.size() / 2),
                listRight.sublist(listRight.size() / 2, listRight.size() - listRight.size() / 2));
        return merge(left, right);
    }

    private MyList<T> merge(MyList<T> list1, MyList<T> list2) {
        MyList<T> result = new MyArrayList<>();
        for (int i = 0, j = 0; i < list1.size() & j < list2.size();) {
            if (i == list1.size() - 1) {
                result.add(list2.get(j++));
            } else if (j == list2.size() - 1) {
                result.add(list1.get(i++));
            } else if (list1.get(i).compareTo(list2.get(j)) < 0) {
                result.add(list1.get(i++));
            } else {
                result.add(list2.get(j++));
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "MyMergeSort";
    }
}
