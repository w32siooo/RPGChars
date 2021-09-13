package util;

import characters.charactertypes.Warlock;
import characters.charactertypes.Warrior;
import enums.ArmorType;
import enums.Attributes;
import enums.Slot;
import enums.WeaponType;
import exceptions.InvalidItemException;
import items.armors.Head;
import items.weapons.Weapon;

import java.util.Arrays;
import java.util.Map;

public class Program {
    public static void main(String[] args) throws InvalidItemException {
        Warlock warlock = new Warlock("Baldur");
        warlock.levelUp();

        Head helm = new Head("bighead", ArmorType.CLOTH,1,1,99,3,4);
        Head helm2 = new Head("smallhead", ArmorType.CLOTH,1,1,-5,3,4);

        warlock.equip(helm);
        warlock.equip(helm2);
        Weapon axe = new Weapon("Axe",5,5,1,WeaponType.STAFF);
        warlock.equip(axe);
        System.out.println(warlock.getEquipment().get(Slot.WEAPON).getItemName());
        System.out.println(warlock.returnTotalAttributes());
    }
}
