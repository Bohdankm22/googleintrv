package datastructure.map;

import datastructure.list.MyList;

public interface IMyMap<K, V> {

    IMyMap<K, V> put(K key, V value);

    V get(K key);

    boolean containsKey(K key);

    boolean empty();

    int size();

    V remove(K key);

    IMyMap<K, V> removeAll();

    MyList<K> getKeyList();
}
