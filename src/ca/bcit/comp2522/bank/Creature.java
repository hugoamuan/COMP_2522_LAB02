package ca.bcit.comp2522.bank;

import ca.bcit.comp2522.bank.exception.DamageException;
import ca.bcit.comp2522.bank.exception.HealingException;

/**
 * This class represents a Creature object.
 * @author Hugo Amuan and Mitchell MacDonald
 * @version 1.0
 */
public class Creature {

    private final String name;
    private final static int MAX_HP = 100;
    private final static int ZERO_HP = 0;
    private final static int ZERO_HEALTH = 0;
    private int age;
    private final Date dateOfBirth;
    private int health;


    /**
     * Creating the creature object.
     * Sets health to maximum (100) and calculates age.
     * @param name the creature is given a name.
     * @param dateOfBirth the creature is given a birthday.
     */
    public Creature(String name, Date dateOfBirth) {
        Creature.validateName(name);
        Creature.validateBirthday(dateOfBirth);
        health = MAX_HP;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.age = getAgeYears();
    }

    /**
     * Validating the parameters for the creatures name.
     * @param name the name in question.
     */
    private static void validateName(String name) {
        if (name == null || name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
    }

    /**
     * Validating the parameters for the birthday.
     * Making sure the creature's birthday is not null or in the future.
     * @param dateOfBirth given birthday
     */
    private static void validateBirthday(Date dateOfBirth) {
        if (dateOfBirth == null) throw new IllegalArgumentException("Date of birth cannot be null");
        // If DOB is after today throw...
        if (dateOfBirth.proceeds(Date.currentDate()))
            throw new IllegalArgumentException("Date of birth cannot be in the future.");
    }

    /**
     * Method to check if the creature is alive or dead
     * @return boolean (true = alive, false = dead).
     */
    public final boolean isAlive() {
        return this.health > ZERO_HP;
    }

    /**
     * Method for when a creatures takes damage and verifying that the amount is not negative.
     * @param damage damage being dealt to the creature.
     * @throws DamageException when damage amount is invalid (is a negative number).
     */
    public void takeDamage(int damage) throws DamageException {
        if(damage < ZERO_HP) {
            throw new DamageException("Damage value cannot be negative.");
        }
        health -= damage;
        setZeroHPifLethal();
    }

    /**
     * Method allowing a creature to be able to restore its hp values after taking damage.
     * @param healAmount The amount to be gained by the creature.
     */
    public void heal(int healAmount) {
        try {
            if (healAmount < ZERO_HEALTH) {
                throw new HealingException("Heal value cannot be negative.");
            }
            if (health + healAmount > MAX_HP) {
                health = MAX_HP;
            } else {
                health += healAmount;
            }
        } catch (HealingException e) {
            // friendly message
            System.out.println(e.getMessage());
        }
    }

    /**
     * Validating the creatures health by changing it to the minimum amount if it goes negative.
     */
    private void setZeroHPifLethal() {
        if (health < ZERO_HEALTH) {
            health = ZERO_HEALTH;
        }
    }

    /**
     * Method that derives the creature's age from its own Date object dateOfBirth.
     * @return age The age of the specified creature.
     */
    public final int getAgeYears() {
        // Use Date Class methods to get today's date.
        final Date currentDate = Date.currentDate();
        final int currentDay = currentDate.getDay();
        final int currentMonth = currentDate.getMonth();
        final int currentYear = currentDate.getYear();

        // Creatures birthday date values.
        final int birthYear = this.dateOfBirth.getYear();
        final int birthMonth = this.dateOfBirth.getMonth();
        final int birthDay = this.dateOfBirth.getDay();

        final int age = currentYear - birthYear;
        // If birth month has been passed age stays the same.
        // If current month is equal to birth month, check if days are equal as well.
        if(currentMonth > birthMonth ||
                (currentMonth == birthMonth && currentDay >= birthDay)){
            return age;
        } else return age - 1;

    }

    /**
     * Accessor for the creature's name.
     * @return name the creature's name.
     */
    public final String getName() {
        return this.name;
    }

    /**
     * Getter for the creature's age.
     * @return age of the creature
     */
    public int getAge() {
        return age;
    }

    /**
     * Printing a creature's information.
     * @return a string of the creature's details.
     */
    public String getDetails(){
        return "Name: " + this.name + "\n" +
                "Birthday: " + this.getCreatureBirthday() + "\n" +
                "Age: " + this.age + "\n" +
                "Health: " + this.health + "\n";
    }

    /**
     * Accessor for the creature's health.
     * @return health of the creature.
     */
    public int getHealth(){
        return health;
    }


    /**
     * Retrieves the creature's birthday in the format YYYY-MM-DD.
     * @return the creature's birthdate as a string.
     */
    public String getCreatureBirthday(){
        return this.dateOfBirth.getYYYYMMDD();
    }
}






