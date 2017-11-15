package datastructure.set;

public interface MySet<E extends Comparable<E>> {

    MySet<E> put(E elem);

    boolean contains(E key);

    boolean empty();

    int size();

    MySet<E> removeAll();
}
