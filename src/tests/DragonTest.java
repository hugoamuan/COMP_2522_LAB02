package tests;
import ca.bcit.comp2522.bank.Creature;
import ca.bcit.comp2522.bank.exception.DamageException;
import ca.bcit.comp2522.bank.Date;
import ca.bcit.comp2522.bank.Dragon;
import ca.bcit.comp2522.bank.Creature;
import ca.bcit.comp2522.bank.exception.HealingException;
import ca.bcit.comp2522.bank.exception.LowFirePowerException;

public class DragonTest {


    public static void main(String[] args) throws LowFirePowerException, DamageException {

        Date d1 = new Date(2001, 5, 28);

        Dragon dragon1 = new Dragon("Ragnarok",d1);
        Creature c1 = new Creature("Krenko", d1);

        System.out.println(dragon1.getDetails());
        System.out.println(c1.getDetails());
        System.out.println("Ragnarok's firepower: " + dragon1.getFirePower());
        System.out.println("Ragnarok is casting firebreath on Krenko!");
        dragon1.breatheFire(c1);
        System.out.println("20 damage is dealt to krenko!");
        System.out.println("Krenko HP = " + c1.getHealth());
        System.out.println("Ragnaroks firepower after casting: " + dragon1.getFirePower());

        // Insufficient firepower also tested!
        // Max of 10 casts on a newly created creature

        // Testing restoration amount over max
        dragon1.restoreFirePower(500);
        System.out.println("Firepower = " + dragon1.getFirePower());

    }

}
