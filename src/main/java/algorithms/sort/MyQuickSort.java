package algorithms.sort;

import datastructure.list.MyList;

import static algorithms.sort.MySelectionSort.swap;

public class MyQuickSort<T extends Comparable<T>> implements Sortable<T> {

    @Override
    public MyList<T> sort(MyList<T> list) {
        return list.size() == 0 ? list : sort(list, 0, list.size() - 1);
    }

    private MyList<T> sort(MyList<T> list, int low, int high) {
        if (low < high) {
            int p = partition(list, low, high);
            sort(list, low, p - 1);
            sort(list, p + 1, high);
        }
        return list;
    }

    private int partition(MyList<T> list, int low, int high) {
        T pivot = list.get(high);
        int j = low - 1;
        for (int i = low; i < high; i++) {
            if (list.get(i).compareTo(pivot) < 0) {
                swap(list, i, ++j);
            }
        }
        if (list.get(high).compareTo(list.get(++j)) < 0) {
            swap(list, high, j);
        }
        return j;
    }

    @Override
    public String toString() {
        return "MyQuickSort";
    }
}
