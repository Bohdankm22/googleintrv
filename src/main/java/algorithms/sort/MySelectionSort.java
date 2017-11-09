package algorithms.sort;

import datastructure.list.MyList;

public class MySelectionSort<T extends Comparable<T>> implements Sortable<T> {

    @Override
    public MyList<T> sort(MyList<T> list) {
        return null;
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
