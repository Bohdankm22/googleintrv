package datastructure.set;

public class MyTreeSet<E extends Comparable<E>> implements MySet<E> {

    @Override
    public MySet<E> put(E elem) {
        return null;
    }

    @Override
    public boolean contains(E key) {
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
    public MySet<E> removeAll() {
        return null;
    }
}
