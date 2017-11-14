package datastructure.heap;

public interface IMyHeap<T extends Comparable<T>> {

    IMyHeap<T> buildMaxHeap();

    IMyHeap<T> buildMinHeap();
}
