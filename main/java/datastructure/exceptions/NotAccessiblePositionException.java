package datastructure.exceptions;

public class NotAccessiblePositionException extends RuntimeException {

    public NotAccessiblePositionException() {
        super("There is no such position in the list.");
    }

    public NotAccessiblePositionException(long position, long size) {
        super(String.format("There is no such position %d in the list with size %d", position, size));
    }
}
