package ca.bcit.comp2522.bank.exception;

/**
 * Represents an exception which is thrown when a dragon tries to cast Breathe Fire without enough firepower.
 * @author Hugo Amuan and Mitchell MacDonald
 * @version 1.0
 */
public class LowFirePowerException extends Exception {
    public LowFirePowerException(String message) {
        super(message);
    }

}
