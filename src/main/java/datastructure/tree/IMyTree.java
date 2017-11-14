package datastructure.tree;

public interface IMyTree<K, V> {

    IMyTree<K, V> put(K key, V value);

    V get(K key);

    boolean containsKey(K key);

    boolean empty();

    int size();
}
