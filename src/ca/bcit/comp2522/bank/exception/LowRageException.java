package ca.bcit.comp2522.bank.exception;

/**
 * Represents an exception which is thrown when an orc does not have enough rage to trigger
 * a critical hit.
 * @author Hugo Amuan and Mitchell MacDonald
 * @version 1.0
 */

public class LowRageException extends Exception {
    public LowRageException(String message) {
        super(message);
    }

}
