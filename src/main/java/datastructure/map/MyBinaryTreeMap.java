package datastructure.map;

import datastructure.exceptions.WrongPositionException;
import datastructure.list.MyArrayList;
import datastructure.list.MyList;
import datastructure.tree.ITree;

/**
 * My implementation of the binary tree.
 * Duplicate keys are not allowed. In case of passing key that already exists the value of associated with the key
 * will be changed to the value that was passed.
 *
 * @param <K> represents a key.
 * @param <V> represents a value.
 */
public class MyBinaryTreeMap<K extends Comparable<K>, V> implements IMyMap<K, V>, ITree<K> {

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
    public MyBinaryTreeMap() {
        size = 0;
    }


    @Override
    public MyBinaryTreeMap<K, V> put(K key, V value) {
        Node parentNode = size == 0 ? null : findParent(key);
        if (parentNode != null && parentNode.getKey().compareTo(key) == 0) {
            parentNode.setValue(value);
        } else {
            return put(key, value, parentNode);
        }
        return this;
    }

    private MyBinaryTreeMap<K, V> put(K key, V value, Node parentNode) {
        Node node = new Node(key, value, parentNode);
        if (parentNode == null) {
            root = node;
        } else if (parentNode.getKey().compareTo(key) > 0) {
            parentNode.setLeftChild(node);
        } else if (parentNode.getKey().compareTo(key) < 0) {
            parentNode.setRightChild(node);
        } else {
            throw new WrongPositionException();
        }
        size++;
        return this;
    }

    private Node findParent(K key) {
        Node node = root;
        while (true) {
            if (node.getKey().compareTo(key) == 0) {
                break;
            } else if (node.getKey().compareTo(key) > 0 && node.getLeftChild() != null) {
                node = node.getLeftChild();
            } else if (node.getKey().compareTo(key) < 0 && node.getRightChild() != null) {
                node = node.getRightChild();
            } else {
                break;
            }
        }
        return node;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        Node node = root;
        while (node != null) {
            if (node.getKey().compareTo(key) == 0) {
                return true;
            } else if (node.getKey().compareTo(key) > 0) {
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
    public V remove(K key) {
        return null;
    }

    @Override
    public MyBinaryTreeMap<K, V> removeAll() {
        root = null;
        size = 0;
        return this;
    }

    @Override
    public String toString() {
        return "MyBinaryTreeMap{" +
                "size = " + size + (size > 0 ?
                "nodes keys = {" + getKeyList() + "}" : "" ) +'}';
    }

    @Override
    public MyList<K> getKeyList() {
        return size == 0 ? new MyArrayList<>() : getKeyList(root);
    }

    private MyList<K> getKeyList(Node node) {
        MyList<K> resultList = new MyArrayList<>();
        if (node.getLeftChild() != null) {
            resultList.addAll(getKeyList(node.getLeftChild()));
        }
        resultList.add(node.getKey());
        if (node.getRightChild() != null) {
            resultList.addAll(getKeyList(node.getRightChild()));
        }
        return resultList;
    }

    @Override
    public ITree<K> put(K key) {
        return put(key, null);
    }

    @Override
    public int getHeight() {
        if (size == 0) return 0;
        return 0;
    }

    @Override
    public K getMin() {
        Node node = size == 0 ? null : root;
        while (node != null) {
            if (node.getLeftChild() == null) {
                return node.getKey();
            }
            node = node.getLeftChild();
        }
        return null;
    }

    @Override
    public K getMax() {
        Node node = size == 0 ? null : root;
        while (node != null) {
            if (node.getRightChild() == null) {
                return node.getKey();
            }
            node = node.getRightChild();
        }
        return null;
    }

    /**
     * Private internal class that represents nodes of the tree.
     * Contains key, value, links to the parent node and left and right children nodes which could be null.
     */
    private class Node {
        private K key;
        private V value;
        private Node parent;
        private Node leftChild;
        private Node rightChild;

        public Node(K key, V value, Node parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
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

        public void setValue(V value) {
            this.value = value;
        }
    }
}
