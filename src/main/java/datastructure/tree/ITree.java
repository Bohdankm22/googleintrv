package datastructure.tree;

public interface ITree<K extends Comparable<K>> {

    int getHeight();

    K getMin();

    K getMax();

    ITree<K> removeAll();
}
