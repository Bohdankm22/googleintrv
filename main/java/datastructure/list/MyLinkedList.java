package datastructure.list;

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
        if (size == 0) {
            first = addedNode;
        } else {
            last.setNext(addedNode);
        }
        last = addedNode;
        size++;
        return true;
    }

}
