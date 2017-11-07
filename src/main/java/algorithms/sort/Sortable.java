package algorithms.sort;

import datastructure.list.MyList;

public interface Sortable<T extends Comparable<T>> {

    MyList<T> sort(MyList<T> list);
}
