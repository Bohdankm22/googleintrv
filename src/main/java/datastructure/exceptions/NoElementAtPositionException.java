package datastructure.exceptions;

public class NoElementAtPositionException extends RuntimeException {

    public NoElementAtPositionException() {
        super("There is no element at the position in list.");
    }

    public NoElementAtPositionException(long position, long size) {
        super(String.format("There is no element at the position %d in list with size %d.", position, size));
    }
}
