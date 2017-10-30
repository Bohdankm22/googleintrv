package datastructure.list;

import datastructure.exceptions.NoElementAtPositionException;
import datastructure.exceptions.NotAccessiblePositionException;

public class MyArrayList<T> {

    private static final int DEFAULT_ARRAY_INIT_SIZE = 16;
    private Object[] internalArray;
    private int lastElementPosition;
    private int arraySize;

    public MyArrayList() {
        internalArray = new Object[DEFAULT_ARRAY_INIT_SIZE];
        lastElementPosition = -1;
        arraySize = DEFAULT_ARRAY_INIT_SIZE;
    }

    public boolean add(T item) {
        internalArray[++lastElementPosition] = item;
        resizeOnAdd();
        return true;
    }

    public boolean add(int position, T item) {
        if (position < 0 || position > lastElementPosition + 1) {
            throw new NotAccessiblePositionException(position, size());
        }
        lastElementPosition++;
        System.arraycopy(internalArray, position, internalArray, position + 1, lastElementPosition - position);
        internalArray[position] = item;
        resizeOnAdd();
        return true;
    }

    public boolean addFirst(T item) {
        return add(0, item);
    }

    public T removeFirst() {
        return remove(0);
    }

    private void resizeOnAdd() {
        if (size() == arraySize) {
            resize(arraySize * 2);
        }
    }

    private void resizeOnRemove() {
        if (size() == arraySize / 4) {
            resize(arraySize / 2);
        }
    }

    private void resize(int newCapacity) {
        arraySize = newCapacity;
        Object[] tmp = new Object[arraySize];
        System.arraycopy(internalArray, 0, tmp, 0, size());
        internalArray = tmp;
    }

    public T get() {
        return get(lastElementPosition);
    }

    public T get(int position) {
        if (position < 0 || position > lastElementPosition) {
            throw new NoElementAtPositionException(position, lastElementPosition);
        }
        return (T) internalArray[position];
    }

    public T getFirst() {
        return get(0);
    }

    public int size() {
        return lastElementPosition + 1;
    }

    public int capacity() {
        return arraySize;
    }

    public T remove() {
        T elem = (T) internalArray[lastElementPosition];
        internalArray[lastElementPosition--] = null;
        resizeOnRemove();
        return elem;
    }

    public T remove(int position) {
        if (position < 0 || position > lastElementPosition) {
            throw new NoElementAtPositionException(position, lastElementPosition);
        }
        T elem = (T) internalArray[position];
        System.arraycopy(internalArray, position + 1, internalArray, position, lastElementPosition - position);
        lastElementPosition--;
        resizeOnRemove();
        return elem;
    }

    public boolean remove(T item) {
        boolean removed = false;
        while (find(item) != -1) {
            remove(find(item));
            removed = true;
        }
        return removed;
    }

    public boolean isEmpty() {
        return lastElementPosition == -1;
    }

    public T pop() {
        return remove();
    }

    public int find(T item) {
        for (int i = 0; i < size(); i++) {
            if (internalArray[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
}
