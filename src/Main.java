import ca.bcit.comp2522.bank.Date;
import ca.bcit.comp2522.bank.Dragon;
import ca.bcit.comp2522.bank.Elf;
import ca.bcit.comp2522.bank.Orc;
import ca.bcit.comp2522.bank.exception.DamageException;
import ca.bcit.comp2522.bank.exception.HealingException;
import ca.bcit.comp2522.bank.exception.LowManaException;
import ca.bcit.comp2522.bank.exception.LowRageException;

public class Main {
    public static void main(String[] args) throws HealingException, DamageException, LowRageException, LowManaException {

        Date d1 = new Date(2001, 5, 28);

        Dragon dragon1 = new Dragon("Paarthurnax", d1);

        Date d2 = new Date(2004, 9, 27);

        Elf elf = new Elf("Calcelmo", d2);

        Date d3 = new Date(1990, 4, 1);

        Orc orc = new Orc("Kharag", d3);

        System.out.println("Is Kharag? an orc?");
        System.out.println(orc instanceof Orc);
        System.out.println("Is Calcelmo an elf?");
        System.out.println(dragon1 instanceof Dragon);
        System.out.println("Is Paarthurnax a dragon?");
        System.out.println(elf instanceof Elf);

        // can use either == or .equals()
        if (orc instanceof Orc) {
            System.out.println(orc.getName() + "\nClass = Orc.");
        }
        if (orc.getClass().equals(Orc.class)) {
            System.out.println(orc.getName() + "\nClass = Orc.");
        }
        if(orc.getClass() == Orc.class) {
            System.out.println(orc.getName() + "\nClass = Orc.");
        }

        if (elf instanceof Elf) {
            System.out.println(elf.getName() + "\nClass = Elf.");
        }

        if (elf.getClass() == Elf.class) {
            System.out.println(elf.getName() + "\nClass = Elf.");
        }
        if (dragon1 instanceof Dragon) {
            System.out.println(dragon1.getName() + "\nClass = Dragon.");
        }

        if (dragon1.getClass() == Dragon.class) {
            System.out.println(dragon1.getName() + "\nClass = Dragon.");
        }


        System.out.println(dragon1.getDetails());

        System.out.println(elf.getDetails());

        System.out.println(orc.getDetails());

        System.out.println("Dragon breathes fire on elf, ten consecutive times!");
        dragon1.breatheFire(elf);
        dragon1.breatheFire(elf);
        dragon1.breatheFire(elf);
        dragon1.breatheFire(elf);
        dragon1.breatheFire(elf);
        dragon1.breatheFire(elf);
        dragon1.breatheFire(elf);
        dragon1.breatheFire(elf);
        dragon1.breatheFire(elf);
        dragon1.breatheFire(elf);
        System.out.println("Ragnarok's Mana Value after casting 10 times: " + dragon1.getFirePower());
        // Casting spell with no firepower
        dragon1.breatheFire(elf);
        System.out.println("The dragon has reduced the elf's mana by 100!");
        System.out.println("Calcelmo casts heal!");
        elf.heal(-100);
        orc.berserk(elf);
        System.out.println("Ragnarok's HP Before: " + dragon1.getHealth());
        elf.castSpell(dragon1);
        System.out.println("Ragnarok's HP: " + dragon1.getHealth());



        }
    }
