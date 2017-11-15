package datastructure.tree;

/**
 * My implementation of the binary tree.
 * Duplicate keys are not allowed. In case of passing key that already exists the value of associated with the key
 * will be changed to the value that was passed.
 *
 * @param <K> represents a key.
 * @param <V> represents a value.
 */
public class MyBinaryTree<K extends Comparable<K>, V> implements IMyTree<K, V> {

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
    public MyBinaryTree() {
        size = 0;
    }


    @Override
    public IMyTree<K, V> put(K key, V value) {
        Node parentNode = size == 0 ? null : findParent(key);
        if (parentNode != null && parentNode.getKey().compareTo(key) == 0) {
            parentNode.setValue(value);
        } else {
            root = parentNode == null ? new Node(key, value, null) : new Node(key, value, findParent(key));
            size++;
        }
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
    public MyBinaryTree<K, V> removeAll() {
        root = null;
        size = 0;
        return this;
    }

    @Override
    public String toString() {
        return "MyBinaryTree{" +
                "size=" + size +
                '}';
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
