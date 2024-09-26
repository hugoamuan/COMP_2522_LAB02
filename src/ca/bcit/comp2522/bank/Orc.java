package ca.bcit.comp2522.bank;
import ca.bcit.comp2522.bank.exception.DamageException;
import ca.bcit.comp2522.bank.exception.LowRageException;

/**
 * This class represents the Orc race of the Creature class.
 * Orcs possess a rage mechanism that enhances their abilities in battle.
 *
 * @author Hugo Amuan and Mitchell MacDonald
 * @version 1.0
 */
public class Orc extends Creature {

    public static final int STARTING_RAGE_AMOUNT = 0;
    public static final int MIN_RAGE_AMOUNT = 0;
    public static final int ORC_CRITICAL_DAMAGE = 30;
    public static final int ORC_NORMAL_DAMAGE = 15;
    private int rage;
    private static final int MAX_RAGE = 30;
    private static final int BERSERK_RAGE_INCREASE = 5;
    private static final int REQ_RAGE_FOR_CRIT = 20;
    private static final int MIN_RAGE_FOR_CRITICAL_HIT = 5;

    /**
     * Constructs an Orc with a specified name, date of birth, health, and initial rage.
     *
     * @param name The name of the orc.
     * @param dateOfBirth The orc's date of birth.
     * @param health The orc's initial health.
     * @param rage The initial rage value of the orc.
     */
    public Orc(String name, Date dateOfBirth, int health, int rage) {
        super(name, dateOfBirth);
        validateRage(rage);
        this.rage = STARTING_RAGE_AMOUNT;
    }

    /**
     * Constructs an Orc with a specified name and date of birth.
     * Rage is initialized to the starting amount.
     *
     * @param name The name of the orc.
     * @param dateOfBirth The orc's date of birth.
     */
    public Orc(String name, Date dateOfBirth) {
        super(name, dateOfBirth);
        validateRage(MAX_RAGE);
        this.rage = STARTING_RAGE_AMOUNT;
    }

    /**
     * Validates the rage value of the orc to ensure it is not negative.
     *
     * @param rage The rage value to be validated.
     * @throws IllegalArgumentException if the rage value is negative.
     */
    private static void validateRage(int rage) {
        if (rage < MIN_RAGE_AMOUNT) {
            throw new IllegalArgumentException("Rage value cannot be negative.");
        }
    }

    /**
     * Activates the orc's berserk ability, increasing rage and applying damage to the target.
     * If the rage is sufficient, a critical hit is applied; otherwise, normal damage is dealt.
     *
     * @param target The targeted creature for the berserk damage.
     * @throws DamageException if the damage value is negative.
     * @throws LowRageException if the rage is insufficient for a critical hit.
     */
    public void berserk(Creature target) throws DamageException, LowRageException {
        try {
            this.rage += BERSERK_RAGE_INCREASE;
            if (rage <= MIN_RAGE_FOR_CRITICAL_HIT) {
                throw new LowRageException(this.getName() + " does not have enough rage to perform a critical hit! 😡");
            }
            if (rage > REQ_RAGE_FOR_CRIT) {
                target.takeDamage(ORC_CRITICAL_DAMAGE);
            } else {
                target.takeDamage(ORC_NORMAL_DAMAGE);
            }
        } catch (LowRageException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Getter method for the orc's current rage value.
     *
     * @return The current rage value of the orc.
     */
    public int getRage() {
        return rage;
    }

    /**
     * Returns a string concatenation of the orc's details, including rage information.
     *
     * @return A string representation of the orc's details.
     */
    @Override
    public String getDetails() {
        return "Name: " + this.getName() + "\n" +
                "Birthday: " + this.getCreatureBirthday() + "\n" +
                "Age: " + this.getAge() + "\n" +
                "Health: " + this.getHealth() + "\n" +
                "Rage: " + this.getRage() + "\n";
    }
}
