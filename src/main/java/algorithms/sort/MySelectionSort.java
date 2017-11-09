package algorithms.sort;

import datastructure.list.MyList;

public class MySelectionSort<T extends Comparable<T>> implements Sortable<T> {

    @Override
    public MyList<T> sort(MyList<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < list.size(); j++) {
                if(list.get(j).compareTo(list.get(min)) < 0) {
                    min = j;
                }
            }
            swap(list, i, min);
        }
        return list;
    }

    private boolean swap(MyList<T> list, int position1, int position2) {
        if (position1 == position2) {
            return false;
        }
        T elem1 = list.get(position1);
        T elem2 = list.get(position2);
        list.remove(position1);
        list.add(position1, elem2);
        list.remove(position2);
        list.add(position2, elem1);
        return true;
    }

    @Override
    public String toString() {
        return "MySelectionSort";
    }
}
