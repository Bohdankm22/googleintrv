package datastructure.map;

import java.util.LinkedList;

public class MyHashMap<K, V> implements MyMap<K, V> {

    private static final int INITIAL_SIZE = 16;
    private static int size;
    private LinkedList<V>[] array;

    public MyHashMap() {
        size = INITIAL_SIZE;
        array = (LinkedList<V>[]) new LinkedList[size];
    }

    @Override
    public MyMap put(K key, V value) {
        return null;
    }

    @Override
    public boolean exists(K key) {
        return array[hash(key, size)] != null && array[hash(key, size)].contains(key);
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    private int hash(K key, int m) {
        return prehash(key) % m;
    }

    private int prehash(K key) {
        return (Integer) key;
    }
}
