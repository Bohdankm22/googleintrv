package datastructure.set;

import datastructure.exceptions.WrongPositionException;

public class MyTreeSet<E extends Comparable<E>> implements MySet<E> {

    /**
     * Refers to the root of the tree. If it is empty the variable keeps null value.
     */
    private Node root;
    /**
     * Stores the size of the tree.
     */
    private int size;

    /**
     * Constructor without arguments.
     */
    public MyTreeSet() {
        size = 0;
    }


    @Override
    public MyTreeSet<E> put(E elem) {
        Node parentNode = size == 0 ? null : findParent(elem);
        if (parentNode != null && parentNode.getElement().compareTo(elem) == 0) {
            return this;
        } else {
            return put(elem, parentNode);
        }
    }

    private MyTreeSet<E> put(E elem, Node parentNode) {
        Node node = new Node(elem, parentNode);
        if (parentNode == null) {
            root = node;
        } else if (parentNode.getElement().compareTo(elem) > 0) {
            parentNode.setLeftChild(node);
        } else if (parentNode.getElement().compareTo(elem) < 0) {
            parentNode.setRightChild(node);
        } else {
            throw new WrongPositionException();
        }
        size++;
        return this;
    }

    private Node findParent(E elem) {
        Node node = root;
        while (true) {
            if (node.getElement().compareTo(elem) == 0) {
                break;
            } else if (node.getElement().compareTo(elem) > 0 && node.getLeftChild() != null) {
                node = node.getLeftChild();
            } else if (node.getElement().compareTo(elem) < 0 && node.getRightChild() != null) {
                node = node.getRightChild();
            } else {
                break;
            }
        }
        return node;
    }

    @Override
    public boolean contains(E elem) {
        Node node = root;
        while (node != null) {
            if (node.getElement().compareTo(elem) == 0) {
                return true;
            } else if (node.getElement().compareTo(elem) > 0) {
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }
        return false;
    }

    @Override
    public boolean empty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public MyTreeSet<E> removeAll() {
        root = null;
        size = 0;
        return this;
    }

    @Override
    public String toString() {
        return "MyBinaryTreeMap{" +
                "size=" + size +
                '}';
    }

    /**
     * Private internal class that represents nodes of the tree.
     * Contains element, value, links to the parent node and left and right children nodes which could be null.
     */
    private class Node {
        private E element;
        private Node parent;
        private Node leftChild;
        private Node rightChild;

        public Node(E element, Node parent) {
            this.element = element;
            this.parent = parent;
        }

        public E getElement() {
            return element;
        }

        public Node getParent() {
            return parent;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }
    }
}
