package characters.charactertypes;

import characters.Character;
import enums.ArmorType;
import enums.Attributes;
import enums.CharTypes;
import enums.WeaponType;
import java.util.List;

public class Mage extends Character {
    private static final int[] startingAttributes = {5, 1, 1, 8};
    private static final int[] levelUpAttributes = {3, 1, 1, 5};
    private static final Attributes primeStat = Attributes.INTELLIGENCE;

    private static final List<WeaponType> allowedWeaponTypes = List.of(WeaponType.STAFF, WeaponType.WAND);
    private static final List<ArmorType> allowedArmorTypes = List.of(ArmorType.CLOTH);
    private static final CharTypes mageType = CharTypes.MAGE;

    public Mage(String name) {
        super(name, startingAttributes, mageType, primeStat, levelUpAttributes, allowedArmorTypes, allowedWeaponTypes);
    }
}
