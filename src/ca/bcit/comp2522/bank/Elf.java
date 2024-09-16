package ca.bcit.comp2522.bank;

public class Elf extends Creature{

    private int mana;
    private final static int MAX_MANA = 50;


    public Elf(String name, Date dateOfBirth, int health, int mana) {
        super(name, dateOfBirth);
        validateMana(mana);
        this.mana = MAX_MANA;
    }

    public Elf(String name, Date dateOfBirth) {
        super(name, dateOfBirth);
        validateMana(mana);
        this.mana = MAX_MANA;
    }


    private void validateMana(int mana) {
        if(mana > MAX_MANA){
            throw new IllegalArgumentException("The Elf's mana is already full.");
        } if (mana < 0) {
            throw new IllegalArgumentException("The Elf's mana cannot be negative.");
        }
    }

    public int getMana() {
        return mana;
    }
}
