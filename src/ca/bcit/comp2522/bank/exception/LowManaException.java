package ca.bcit.comp2522.bank.exception;

/**
 * Represents an exception which is thrown when an elf does not have enough mana to cast a given spell.
 * @author Hugo Amuan and Mitchell MacDonald
 * @version 1.0
 */
public class LowManaException extends Exception {
    public LowManaException(String message) {
        super(message);
    }

}
