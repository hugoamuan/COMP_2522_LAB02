package ca.bcit.comp2522.bank;

import ca.bcit.comp2522.bank.exception.DamageException;
import ca.bcit.comp2522.bank.exception.HealingException;

/**
 * This class represents a Creature object.
 * @author HugoAmuan
 * @version 1.0
 */
public class Creature {

    private final String name;
    private final static int MAX_HP = 100;
    private final static int ZERO = 0;
    private int age;

    private final Date dateOfBirth;
    private int health;

    public Creature(String name, Date dateOfBirth) {
        Creature.validateName(name);
        Creature.validateBirthday(dateOfBirth);
        health = MAX_HP;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.age = getAgeYears();
    }

    private static void validateName(String name) {
        if (name == null || name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
    }

    private static void validateBirthday(Date dateOfBirth) {
        if (dateOfBirth == null) throw new IllegalArgumentException("Date of birth cannot be null");
        if (dateOfBirth.proceeds(Date.currentDate()))
            throw new IllegalArgumentException("Date of birth cannot be in the future.");
    }

    public boolean isAlive() {
        return this.health > ZERO;
    }

    public void takeDamage(int damage) throws DamageException {
        if(damage < ZERO) {
            throw new DamageException("Damage value cannot be negative.");
        }
        health -= damage;
        setZeroHPifLethal();
    }

    public void heal(int healAmount) throws HealingException {
        if(healAmount < ZERO) {
            throw new HealingException("Heal value cannot be negative.");
        }
        if (health + healAmount > MAX_HP) {
            health = MAX_HP;
        } else {
            health += healAmount;
        }
    }

    private void setZeroHPifLethal() {
        if (health < ZERO) {
            health = ZERO;
        }
    }

    public int getAgeYears() {
        final Date currentDate = Date.currentDate();

        final int currentDay = currentDate.getDay();
        final int currentMonth = currentDate.getMonth();
        final int currentYear = currentDate.getYear();

        final int birthYear = this.dateOfBirth.getYear();
        final int birthMonth = this.dateOfBirth.getMonth();
        final int birthDay = this.dateOfBirth.getDay();

        final int age = currentYear - birthYear;
        if(currentMonth > birthMonth || (currentMonth == birthMonth && currentDay >= birthDay)){
            return age;
        } else return age - 1;

    }

    public String getName() {
        return this.name;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public String getDetails(){
        return "Name: " + this.name + "\n" +
                "Birthday: " + this.getCreatureBirthday() + "\n" +
                "Age: " + this.age + "\n" +
                "Health: " + this.health + "\n";

    }

    public int getHealth(){
        return health;
    }

    public String getCreatureBirthday(){
        return this.dateOfBirth.getYYYYMMDD();
    }
}






