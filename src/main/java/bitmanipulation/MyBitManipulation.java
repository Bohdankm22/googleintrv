package bitmanipulation;

public class MyBitManipulation {

    public static int setBit(int x, int position) {
        int mask = 1 << position;
        return x | mask;
    }

    public static int clearBit(int x, int position) {
        int mask = 1 << position;
        return x ^ mask;
    }
}
