package characters.charactertypes;

import characters.Character;
import enums.ArmorType;
import enums.Attributes;
import enums.CharTypes;
import enums.WeaponType;

import java.util.List;

public class Rogue extends Character {
    private static final int[] startingAttributes = {8, 2, 6, 1};
    private static final int[] levelUpAttributes = {3, 1, 4, 1};
    private static final Attributes primeStat = Attributes.DEXTERITY;

    private static final CharTypes rogueType = CharTypes.ROGUE;
    private static final List<WeaponType> allowedWeaponTypes = List.of(WeaponType.DAGGER, WeaponType.SWORD);
    private static final List<ArmorType> allowedArmorTypes = List.of(ArmorType.MAIL, ArmorType.LEATHER);

    public Rogue(String name) {
        super(name, startingAttributes, rogueType, primeStat, levelUpAttributes, allowedArmorTypes, allowedWeaponTypes);
    }

}
