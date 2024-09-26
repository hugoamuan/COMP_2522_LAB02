package ca.bcit.comp2522.bank.exception;

/**
 * Represents an exception which is thrown when a creature receives an invalid damage value.
 * @author Hugo Amuan and Mitchell MacDonald
 * @version 1.0
 */
public class DamageException extends Exception {
    public DamageException(String message) {
        super(message);
    }

}
