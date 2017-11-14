package datastructure.list;

import datastructure.exceptions.NoElementAtPositionException;
import datastructure.exceptions.NotAccessiblePositionException;
import datastructure.queue.MyQueue;
import datastructure.stack.MyStack;

public class MyLinkedList<T> implements MyList<T>, MyQueue<T>, MyStack<T>, Cloneable {

    private Node first;
    private Node last;
    private int size;

    public MyLinkedList() {
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T remove() {
        return pop();
    }

    @Override
    public T remove(int position) {
        if (size() > 0 && position == 0) {
            return removeFirst();
        }
        if (position > size() - 1) {
            throw new NoElementAtPositionException(position, size() - 1);
        }
        if (position == size() - 1) {
            return removeLast();
        }
        Node node = first;
        for (int i = 0; i < position - 1; i++) {
            node = node.getNext();
        }
        T result = node.getNext().getElem();
        node.setNext(node.getNext().getNext());
        size--;
        return result;
    }

    private T removeLast() {
        return pop();
    }

    @Override
    public boolean enqueue(T item) {
        return add(item);
    }

    @Override
    public T dequeue() {
        return removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean removeAll() {
        size = 0;
        first = null;
        last = null;
        return true;
    }

    @Override
    public boolean add(T item) {
        Node addedNode = new Node(item);
        if (size() == 0) {
            first = addedNode;
        } else {
            last.setNext(addedNode);
        }
        last = addedNode;
        size++;
        return true;
    }

    public T get(int position) {
        if (position < 0 || position >= size()) {
            throw new NoElementAtPositionException(position, size() - 1);
        }
        if (position == 0) {
            return getFirst();
        }
        if (position == size() - 1) {
            return getLast();
        }
        Node node = first;
        for (int i = 0; i < position; i++) {
            node = node.getNext();
        }
        return node.getElem();
    }

    public boolean addFirst(T item) {
        Node addedNode = new Node(item);
        if (size() == 0) {
            last = addedNode;
        } else {
            addedNode.setNext(first);
        }
        first = addedNode;
        size++;
        return true;
    }

    @Override
    public T removeFirst() {
        return popFirst();
    }

    @Override
    public T get() {
        return getLast();
    }

    public T popFirst() {
        T result = null;
        if (size() != 0) {
            result = first.getElem();
            first = first.getNext();
            if (size() == 1) {
                last = null;
            }
            size--;
        }
        return result;
    }

    @Override
    public boolean push(T item) {
        return add(item);
    }

    public T pop() {
        T result = null;
        if (size() != 0) {
            Node node = first;
            for (int i = 0; i < size() - 2; i++) {
                node = node.getNext();
            }
            result = last.getElem();
            last = size() != 0 ? node : null;
            first = size() != 0 ? first : null;
            size--;
        }
        return result;
    }

    public T getFirst() {
        if (size() == 0) {
            throw new NoElementAtPositionException();
        }
        return first.getElem();
    }

    public T getLast() {
        if (size() == 0) {
            throw new NoElementAtPositionException();
        }
        return last.getElem();
    }

    @Override
    public boolean add(int position, T item) {
        if (position < 0 || position > size()) {
            throw new NotAccessiblePositionException(position, size() - 1);
        } else if (position == size()) {
            return add(item);
        } else if (position == 0) {
            return addFirst(item);
        }
        Node node = first;
        for (int i = 0; i < position - 1; i++) {
            node = node.getNext();
        }
        Node addedNode = new Node(item);
        addedNode.setNext(node.getNext());
        node.setNext(addedNode);
        size++;
        return true;
    }

    @Override
    public MyList<T> sublist(int numbOfElem) {
        return sublist(0, numbOfElem);
    }

    @Override
    public MyList<T> sublist(int startPosition, int numbOfElem) {
        if (startPosition < 0 || startPosition + numbOfElem > size()) {
            throw new NoElementAtPositionException();
        }
        MyList<T> result = new MyLinkedList<>();
        for (int i = 0; i < numbOfElem; i++) {
            result.add(get(startPosition + i));
        }
        return result;
    }

    @Override
    public MyLinkedList<T> clone() {
        return (MyLinkedList<T>) sublist(size());
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "size=" + size +
                '}';
    }

    private class Node {
        T elem;
        Node next;

        private Node(T elem) {
            this.elem = elem;
        }

        private Node getNext() {
            return next;
        }

        private void setNext(Node next) {
            this.next = next;
        }

        private T getElem() {
            return elem;
        }
    }
}
