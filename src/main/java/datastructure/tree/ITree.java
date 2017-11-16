package datastructure.tree;

public interface ITree<K extends Comparable<K>> {

    ITree<K> put(K key);

    int getHeight();

    K getMin();

    K getMax();

    ITree<K> removeAll();
}
