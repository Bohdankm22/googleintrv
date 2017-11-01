package datastructure.Queue;

public interface MyQueue<T> {

    boolean enqueue(T item);

    T dequeue();

    boolean isEmpty();
}
