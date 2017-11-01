package datastructure.list;

import datastructure.exceptions.NoElementAtPositionException;
import datastructure.exceptions.NotAccessiblePositionException;

public class MyLinkedList<T> implements MyList<T> {

    private Node first;
    private Node last;
    private int size;

    private class Node {
        T elem;
        Node next;

        public Node(T elem) {
            this.elem = elem;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public T getElem() {
            return elem;
        }

        public void setElem(T elem) {
            this.elem = elem;
        }
    }

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
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
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
        return null;
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

    public T pop() {
        T result = null;
        if (size() != 0) {
            Node node = first;
            for (int i = 0; i < size() - 2; i++) {
                node = node.getNext();
            }
            result = last.getElem();
            last = size() != 1 ? node : null;
            first = size() != 1 ? first : null;
            size--;
        }
        return result;
    }

    public T getFirst() {
        return size() != 0 ? first.getElem() : null;
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
}