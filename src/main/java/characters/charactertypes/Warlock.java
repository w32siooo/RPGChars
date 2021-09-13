package characters.charactertypes;

import characters.Character;
import enums.ArmorType;
import enums.CharTypes;
import enums.WeaponType;
import enums.Attributes;

import java.util.List;

public class Warlock extends Character {
    private static final int[] warlockStartingAttributes = {10, 5, 2, 1};
    private static final int[] warriorLevelUpAttributes = {5, 3, 2, 1};
    private static final Attributes warlockPrimeStat = Attributes.INTELLIGENCE;

    private static final CharTypes warlockType = CharTypes.WARLOCK;
    private static final List<WeaponType> warlockAllowedWeapons = List.of(WeaponType.SWORD, WeaponType.STAFF);
    private static final List<ArmorType> warlockAllowedArmors = List.of(ArmorType.CLOTH);

    public Warlock(String name) {
        super(name, warlockStartingAttributes, warlockType, warlockPrimeStat, warriorLevelUpAttributes, warlockAllowedArmors, warlockAllowedWeapons);
    }
}
