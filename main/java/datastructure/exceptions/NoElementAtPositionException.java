package datastructure.exceptions;

public class NoElementAtPositionException extends RuntimeException {

    public NoElementAtPositionException() {
        super("There is no element at the position in list.");
    }

    public NoElementAtPositionException(int position, int size) {
        super(String.format("There is no element at the position %d in list with size %d.", position, size));
    }

    public NoElementAtPositionException(String message) {
        super(message);
    }
}
