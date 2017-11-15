package datastructure.tree;

public class MyBinaryTree<K extends Comparable<K>, V> implements IMyTree<K, V> {

    private Node root;
    private int size;

    public MyBinaryTree() {
        size = 0;
    }

    @Override
    public IMyTree<K, V> put(K key, V value) {
        Node node = size == 0 ? new Node(key, value, null) : new Node(key, value, findParent(key));
        root = node;
        size++;
        return this;
    }

    private Node findParent(K key) {
        Node node = root;
        while (node != null) {
            node = node.getKey().compareTo(key) > 0 ? node.getLeftChild() : node.getRightChild();
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
    public MyBinaryTree<K, V> removeAll() {
        root = null;
        size = 0;
        return this;
    }

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
            this.leftChild = leftChild;
            this.rightChild = rightChild;
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
    }
}
