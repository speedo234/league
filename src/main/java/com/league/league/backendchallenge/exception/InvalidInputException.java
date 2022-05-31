package com.league.league.backendchallenge.exception;

public class InvalidInputException extends ApplicationException {
    public InvalidInputException() {
        super("Invalid!");
    }

    public InvalidInputException(String message) {
        super(message);
    }

    public InvalidInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidInputException(Throwable cause) {
        super(cause);
    }
}
