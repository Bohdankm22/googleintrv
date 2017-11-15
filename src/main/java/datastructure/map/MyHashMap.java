package datastructure.map;

import datastructure.list.MyList;

import java.util.LinkedList;

public class MyHashMap<K, V> implements IMyMap<K, V> {

    private static final int INITIAL_SIZE = 16;
    private static int size;
    private LinkedList<V>[] array;

    public MyHashMap() {
        size = INITIAL_SIZE;
        array = (LinkedList<V>[]) new LinkedList[size];
    }

    @Override
    public IMyMap<K, V> put(K key, V value) {
        return null;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public boolean empty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public IMyMap<K, V> removeAll() {
        return null;
    }

    @Override
    public MyList<K> getKeyList() {
        return null;
    }

    private int hash(K key, int m) {
        return prehash(key) % m;
    }

    private int prehash(K key) {
        return (Integer) key;
    }
}
