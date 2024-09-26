package ca.bcit.comp2522.bank;
import ca.bcit.comp2522.bank.exception.DamageException;
import ca.bcit.comp2522.bank.exception.LowManaException;

/**
 * This class represents the Elf race, which is a subclass of Creature.
 * The Elf can cast spells, manage mana, and has specific characteristics such as
 * mana restoration and damage handling.
 *
 * @version 1.0
 */
public class Elf extends Creature{

    private static final int BASE_DAMAGE = 10;
    public static final int MIN_MANA_ALLOWED = 0;

    private int mana;
    private final static int MAX_MANA_FIFTY = 50;
    private final static int BASIC_SPELL_COST = 5;

    /**
     * Constructs an Elf with specified name, date of birth, and initial health.
     *
     * @param name The name of the elf.
     * @param dateOfBirth The elf's date of birth.
     * @param health The elf's initial health.
     * @param mana The elf's initial mana level.
     */
    public Elf(String name, Date dateOfBirth, int health, int mana) {
        super(name, dateOfBirth);
        validateMana(mana);
        this.mana = MAX_MANA_FIFTY;
    }

    /**
     * Constructs an Elf with a specified name and date of birth. Mana is initialized to the maximum value.
     *
     * @param name The name of the elf.
     * @param dateOfBirth The elf's date of birth.
     */
    public Elf(String name, Date dateOfBirth) {
        super(name, dateOfBirth);
        this.mana = MAX_MANA_FIFTY;
    }

    /**
     * Validates the mana pool of the elf.
     * Ensures that the mana is not greater than the maximum mana or less than zero.
     *
     * @param mana The mana value to be validated.
     * @throws IllegalArgumentException if the mana is out of the valid range.
     */
    private void validateMana(int mana) {
        if(mana > MAX_MANA_FIFTY){
            throw new IllegalArgumentException("The Elf's mana is already full.");
        }
        if (mana < MIN_MANA_ALLOWED) {
            throw new IllegalArgumentException("The Elf's mana cannot be negative.");
        }
    }

    /**
     * Getter method for mana.
     *
     * @return The current mana of the elf.
     */
    public int getMana() {
        return mana;
    }

    /**
     * Casts a basic damaging spell on the target creature.
     * Reduces the elf's mana by a fixed cost.
     *
     * @param target The creature to receive the spell damage.
     * @throws DamageException if the elf has insufficient mana to cast the spell.
     */
    public void castSpell(Creature target) throws DamageException {
        try {
            if (this.mana < BASIC_SPELL_COST) {
                throw new LowManaException("Not enough mana required to cast!");
            }
            this.mana -= BASIC_SPELL_COST;
            target.takeDamage(BASE_DAMAGE);
        } catch (LowManaException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Restores the elf's mana by a specified amount.
     * If the restored mana exceeds the maximum, it is capped at the maximum value.
     *
     * @param amount The amount of mana to be restored.
     * @throws IllegalArgumentException if the amount is negative.
     */
    public void restoreMana(int amount) {
        if(amount < 0) {
            throw new IllegalArgumentException(("Value given: %d \nValue cannot be negative.").formatted(amount));
        }
        mana += amount;
        if(mana > MAX_MANA_FIFTY) {
            mana = MAX_MANA_FIFTY;
        }
    }

    /**
     * Altered getDetails() from the Creature class.
     *
     * @return String concatenation of the elf's details.
     */
    @Override
    public String getDetails(){
        return "Name: " + this.getName() + "\n" +
                "Birthday: " + this.getCreatureBirthday() + "\n" +
                "Age: " + this.getAge() + "\n" +
                "Health: " + this.getHealth() + "\n" +
                "Mana: " + this.getMana() + "\n";
    }
}
