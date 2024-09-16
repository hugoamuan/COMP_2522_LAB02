package tests;

import static org.junit.Assert.fail;

import ca.bcit.comp2522.bank.Creature;
import ca.bcit.comp2522.bank.exception.DamageException;
import ca.bcit.comp2522.bank.Date;
import ca.bcit.comp2522.bank.exception.HealingException;

public class CreatureTest {

    public static void main(String[] args) throws DamageException, HealingException {

        Date d1 = new Date (2001, 9, 16);
        Creature c1 = new Creature("Krenko", d1);

        System.out.println(c1.getDetails());

        System.out.println("Damaging Krenko by 27 points");
        c1.takeDamage(27);
        System.out.println(c1.getDetails());

        System.out.println("Healing Krenko by 13 points");
        c1.heal(13);
        System.out.println(c1.getDetails());

        System.out.println("Testing overheal:\nOverhealing by 500");
        c1.heal(500);
        System.out.println(c1.getDetails());

        System.out.println("Testing lethal damage: \nDoing 600 damage to Krenko!!! pew pew");
        c1.takeDamage(600);
        System.out.println(c1.getDetails());

        // Testing negative healing
//        c1.heal(-12);
        c1.heal(100);
        // Testing negative damage output
        c1.takeDamage(-100);


    }
}