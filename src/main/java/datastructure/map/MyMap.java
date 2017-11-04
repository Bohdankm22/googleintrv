package datastructure.map;

public interface MyMap<K, V> {

    MyMap put(K key, V value);

    boolean exists(K key);

    V get(K key);

    V remove(K key);
}
