package characters.charactertypes;

import characters.Character;
import enums.ArmorType;
import enums.Attributes;
import enums.CharTypes;
import enums.WeaponType;

import java.util.List;

public class Ranger extends Character {
    private static final int[] rangerStartingAttributes = {8, 1, 7, 1};
    private static final int[] rangerLevelUpAttributes = {2, 1, 5, 1};
    private static final Attributes rangerPrimeStat = Attributes.DEXTERITY;

    private static final CharTypes rangerType = CharTypes.RANGER;
    private static final List<WeaponType> rangerAllowedWeapons = List.of(WeaponType.BOW);
    private static final List<ArmorType> rangerAllowedArmors = List.of(ArmorType.LEATHER, ArmorType.MAIL);

    public Ranger(String name) {
        super(name, rangerStartingAttributes, rangerType, rangerPrimeStat, rangerLevelUpAttributes, rangerAllowedArmors, rangerAllowedWeapons);
    }
}


