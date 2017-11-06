package datastructure.map;

import datastructure.list.MyLinkedList;

public class MyHashMap<K, V> implements MyMap<K, V> {

    private MyLinkedList<V>[] array;
    private static final int INITIAL_SIZE = 16;

    public MyHashMap() {

    }

    @Override
    public MyMap put(K key, V value) {
        return null;
    }

    @Override
    public boolean exists(K key) {
        return false;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    private int hash(int k, int m) {
        return k % m;
    }
}
