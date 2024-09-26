package ca.bcit.comp2522.bank;

import ca.bcit.comp2522.bank.exception.DamageException;
import ca.bcit.comp2522.bank.exception.LowFirePowerException;

/**
 * This class represents the Dragon race of the Creature class.
 * @author Hugo Amuan and Mitchell MacDonald
 */

public class Dragon extends Creature {


    private int firePower;
    private static final int MAX_FIREPOWER = 100;
    private static final int BREATHE_FIRE_SPELL_COST = 10;
    // DMG = damage
    private static final int BREATHE_FIRE_DMG = 20;

    /**
     * Constructor for the Dragon class with specified fire power.
     * Sets firepower to the provided value after validation.
     *
     * @param name        the name of the dragon
     * @param dateOfBirth the date of birth of the dragon
     * @param firePower   the initial firepower of the dragon
     * @throws IllegalArgumentException if firePower is out of valid range
     */
    public Dragon(String name, Date dateOfBirth, int firePower) {
        super(name, dateOfBirth);
        Dragon.validateFirePower(firePower);
        this.firePower = firePower;
    }

    public Dragon(String name, Date dateOfBirth, int health, int firePower) {
        super(name, dateOfBirth);
        Dragon.validateFirePower(firePower);
        this.firePower = firePower;
    }


    /**
     * Constructor for the Dragon class with default maximum fire power.
     * Sets fire power to MAX_FIREPOWER after validation.
     *
     * @param name        the name of the dragon
     * @param dateOfBirth the date of birth of the dragon
     * @throws IllegalArgumentException if firePower initialization is invalid
     */
    public Dragon(String name, Date dateOfBirth){
        super(name, dateOfBirth);
        Dragon.validateFirePower(firePower);
        this.firePower = MAX_FIREPOWER;
    }
    /**
     * Validates the dragon's firepower amount.
     *
     * @param firePower the dragon's firepower to validate
     * @throws IllegalArgumentException if firePower is negative or exceeds MAX_FIREPOWER
     */
    private static void validateFirePower(int firePower) {
        if (firePower < 0) {
            throw new IllegalArgumentException("Fire power must be a positive number.");
        } if(firePower > MAX_FIREPOWER) {
            throw new IllegalArgumentException("Fire power must be a number between 0 and "+MAX_FIREPOWER);
        }
    }

    /**
     * Getter method for firepower
     * @return firepower
     */
    public int getFirePower() {
        return firePower;
    }

    /**
     * Dragon specific ability to breathe fire upon its opponents
     * @param target The creature to be damaged by fire.
     */
    public void breatheFire(final Creature target) {
        try {
            if (this.firePower < BREATHE_FIRE_SPELL_COST) {
                throw new LowFirePowerException("Insufficient firepower!");
            }
            firePower -= BREATHE_FIRE_SPELL_COST;
            target.takeDamage(BREATHE_FIRE_DMG);
        } catch (LowFirePowerException e) {
            System.out.println(this.getName() + " does not have enough firepower left!");
        } catch (DamageException e) {
            System.out.println("Something went wrong when trying to damage the target. The attack failed.");
        }
    }

    /**
     * Restores the dragon's firepower by a specified amount.
     * Ensures that firepower does not exceed MAX_FIREPOWER.
     *
     * @param amount the amount of firepower to restore
     * @throws IllegalArgumentException if the amount is negative
     */
    public void restoreFirePower(int amount) {
        firePower += amount;
        if(amount < 0) {
            throw new IllegalArgumentException(("Value given: %d \nValue cannot be negative.").formatted(amount));
        }
        if(firePower > MAX_FIREPOWER) {
            firePower = MAX_FIREPOWER;
        }
    }

    /**
     * Overrided version of the Creature getDetails method.
     * @return String Creature details + the dragons firepower value.
     */
    @Override
    public String getDetails(){
        return "Name: " + this.getName() + "\n" +
                "Birthday: " + this.getCreatureBirthday() + "\n" +
                "Age: " + this.getAge() + "\n" +
                "Health: " + this.getHealth() + "\n" +
                "Firepower: " + this.getFirePower() + "\n";

    }
}