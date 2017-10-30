package datastructure.list;

import datastructure.exceptions.NoElementAtPositionException;

public class MyLinkedList<T> {

    private Node first;
    private Node last;
    private long size;

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

    public long size() {
        return size;
    }

    public boolean empty() {
        return size() == 0;
    }

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

    public T get(long position) {
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
        return size() != 0 ? last.getElem() : null;
    }

}
