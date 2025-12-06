package org.example;

// Klasa wyjątek
// Exception (checked exception) RuntimeException (unchecked exception)
public class InvalidTransactionException extends RuntimeException {
    public InvalidTransactionException(String errorMessage) {
        super(errorMessage);
    }
}