package datastructure.exceptions;

public class WrongPositionException extends RuntimeException {

    public WrongPositionException() {
        super("The element was placed in wrong position in data structure or position was not found.");
    }
}
