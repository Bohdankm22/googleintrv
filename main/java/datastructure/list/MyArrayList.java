package datastructure.list;

public class MyArrayList<T> {

    private static final int DEFAULT_ARRAY_INIT_SIZE = 12;
    private Object[] internalArray;
    private int lastPosition;
    private int arraySize;

    public MyArrayList() {
        internalArray = new Object[DEFAULT_ARRAY_INIT_SIZE];
        lastPosition = 0;
        arraySize = DEFAULT_ARRAY_INIT_SIZE;
    }

    public boolean add(T item) {
        internalArray[lastPosition] = item;
        if (lastPosition / arraySize == 1) {
            arraySize = (int) Math.round(arraySize * 1.5);
            Object[] tmp = new Object[arraySize];
            System.arraycopy(internalArray, 0, tmp, 0, lastPosition + 1);
            internalArray = tmp;
        }
        return true;
    }
}
