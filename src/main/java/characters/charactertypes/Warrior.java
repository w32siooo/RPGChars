package characters.charactertypes;

import characters.Character;
import enums.ArmorType;
import enums.CharTypes;
import enums.WeaponType;
import enums.Attributes;

import java.util.List;

public class Warrior extends Character {
    private static final int[] startingAttributes = {10, 5, 2, 1};
    private static final int[] levelUpAttributes = {5, 3, 2, 1};
    private static final Attributes primeStat = Attributes.STRENGTH;

    private static final CharTypes warriorType = CharTypes.WARRIOR;
    private static final List<WeaponType> allowedWeaponTypes = List.of(WeaponType.AXE, WeaponType.SWORD,WeaponType.HAMMER);
    private static final List <ArmorType> allowedArmorTypes = List.of(ArmorType.MAIL,ArmorType.PLATE);

    public Warrior(String name) {
        super(name, startingAttributes, warriorType, primeStat, levelUpAttributes,allowedArmorTypes,allowedWeaponTypes);
    }

}
