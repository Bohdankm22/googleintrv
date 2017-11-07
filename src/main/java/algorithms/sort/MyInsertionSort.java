package algorithms.sort;

import datastructure.list.MyList;

public class MyInsertionSort<T extends Comparable<T>> implements Sortable<T> {

    @Override
    public MyList<T> sort(MyList<T> list) {
        for (int i = 1; i < list.size(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(i).compareTo(list.get(j)) <= 0) {
                    insert(list, i, j);
                }
            }
        }
        return list;
    }

    private boolean insert(MyList<T> list, int i, int j) {
        return list.add(j, list.remove(i));
    }
}
