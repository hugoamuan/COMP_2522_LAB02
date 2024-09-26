package ca.bcit.comp2522.bank.exception;

/**
 * Represents an exception which is thrown when a creature receives an invalid healing value.
 * @author Hugo Amuan and Mitchell MacDonald
 * @version 1.0
 */
public class HealingException extends Exception {
    public HealingException(String message) {
        super(message);
    }
}
