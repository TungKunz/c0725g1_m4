package org.example.book.exception;

public class NoBooksAvailableError extends RuntimeException {
    public NoBooksAvailableError(String message) {
        super(message);
    }
}
