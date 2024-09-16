package ca.bcit.comp2522.bank;

import ca.bcit.comp2522.bank.exception.DamageException;
import ca.bcit.comp2522.bank.exception.LowFirePowerException;

public class Dragon extends Creature {

    private int firePower;

    private static final int MAX_FIREPOWER = 100;
    private static final int MAX_HP = 100;
    // Spell Cost = SC
    private static final int BREATHE_FIRE_SC = 10;

    // Damage Values
    private static final int BREATHE_FIRE_DMG = 20;

    // New Dragon
    public Dragon(String name, Date dateOfBirth, int health, int firePower) {
        super(name, dateOfBirth);
        Dragon.validateFirePower(firePower);
        this.firePower = firePower;
        health = MAX_HP;
    }

    // New Dragon using superclass
    public Dragon(String name, Date dateOfBirth){
        super(name, dateOfBirth);
        Dragon.validateFirePower(firePower);
        this.firePower = MAX_FIREPOWER;
    }

    private static void validateFirePower(int firePower) {
        if (firePower < 0) {
            throw new IllegalArgumentException("Fire power must be a positive number.");
        } if(firePower > MAX_FIREPOWER) {
            throw new IllegalArgumentException("Fire power must be a number between 0 and "+MAX_FIREPOWER);
        }
    }

    public int getFirePower() {
        return firePower;
    }

    public void breatheFire(final Creature target) throws DamageException, LowFirePowerException {
        if(this.firePower < BREATHE_FIRE_SC) {
            throw new LowFirePowerException("Insufficient firepower!");
        }
        firePower -= BREATHE_FIRE_SC;
        target.takeDamage(BREATHE_FIRE_DMG);
    }

    public void restoreFirePower(int amount) {
        firePower += amount;
        if(amount < 0) {
            throw new IllegalArgumentException(("Value given: %d \nValue cannot be negative.").formatted(amount));
        }
        if(firePower > MAX_FIREPOWER) {
            firePower = MAX_FIREPOWER;
        }
    }


    @Override
    public String getDetails(){
        return "Name: " + this.getName() + "\n" +
                "Birthday: " + this.getCreatureBirthday() + "\n" +
                "Age: " + this.getAge() + "\n" +
                "Health: " + this.getHealth() + "\n" +
                "Firepower: " + this.getFirePower() + "\n";

    }
}