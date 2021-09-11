package characters.charactertypes;

import characters.Character;
import enums.ArmorType;
import enums.Attributes;
import enums.CharTypes;
import enums.WeaponType;

import java.util.List;

public class Rogue extends Character {
    private static final int[] rogueStartingAttributes = {8, 2, 6, 1};
    private static final int[] rogueLevelUpAttributes = {3, 1, 4, 1};
    private static final Attributes roguePrimeStat = Attributes.DEXTERITY;

    private static final CharTypes rogueType = CharTypes.ROGUE;
    private static final List<WeaponType> rogueAllowedWeapons = List.of(WeaponType.DAGGER, WeaponType.SWORD);
    private static final List<ArmorType> rogueAllowedArmors = List.of(ArmorType.MAIL, ArmorType.LEATHER);

    public Rogue(String name) {
        super(name, rogueStartingAttributes, rogueType, roguePrimeStat, rogueLevelUpAttributes, rogueAllowedArmors, rogueAllowedWeapons);
    }

}
