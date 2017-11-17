package designpatterns.singleton;

public class SimpleSingleton {

    private static SimpleSingleton instance;

    private SimpleSingleton() {
    }

    public synchronized static SimpleSingleton getInstance() {
        instance = instance != null ? instance : new SimpleSingleton();
        return instance;
    }
}
