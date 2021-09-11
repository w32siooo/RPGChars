package util;

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
        Warrior warrior = new Warrior("Baldur");
        Head helm = new Head("bighead", ArmorType.PLATE,1,1,99,3,4);
        Head helm2 = new Head("smallhead", ArmorType.PLATE,1,1,-5,3,4);

        warrior.equip(helm);
        warrior.equip(helm2);
        Weapon axe = new Weapon("Axe",5,5,1,WeaponType.AXE);
        warrior.equip(axe);
        System.out.println(warrior.getEquipment().get(Slot.WEAPON).getItemName());
        System.out.println(warrior.returnTotalAttributes());
        System.out.println(warrior.calculateDps());





    }
}
