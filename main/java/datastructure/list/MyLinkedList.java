package datastructure.list;

public class MyLinkedList<T> {

    private Node first;
    private Node last;
    private long size;

    private class Node {
        T elem;
        Node next;
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


}
