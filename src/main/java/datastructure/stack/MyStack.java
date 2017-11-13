package datastructure.stack;

public interface MyStack<T> {

    boolean push(T item);

    T pop();

    boolean isEmpty();

    boolean removeAll();

    int size();
}