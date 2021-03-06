package datastructure.list;

public interface MyList<T> extends Cloneable {

    boolean add(T item);

    boolean add(int position, T item);

    boolean addFirst(T item);

    T removeFirst();

    T get();

    T get(int position);

    T getFirst();

    int size();

    T remove();

    T remove(int position);

    boolean isEmpty();

    boolean removeAll();

    MyList<T> sublist(int numbOfElem);

    MyList<T> sublist(int startPosition, int numbOfElem);

    MyList<T> clone();

    boolean addAll(MyList<T> list);
}
