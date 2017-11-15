package datastructure.set;

public interface MySet<E> {

    MySet<E> put(E elem);

    boolean contains(E key);

    boolean empty();

    int size();

    MySet<E> removeAll();
}
