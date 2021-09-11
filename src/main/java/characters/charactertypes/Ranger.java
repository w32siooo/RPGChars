package characters.charactertypes;

import characters.Character;
import enums.ArmorType;
import enums.Attributes;
import enums.CharTypes;
import enums.WeaponType;
import exceptions.InvalidItemException;
import items.ItemInterface;

import java.util.List;

public class Ranger extends Character {
    private static final int[] startingAttributes = {8, 1, 7, 1};
    private static final int[] levelUpAttributes = {2, 1, 5, 1};
    private static final Attributes primeStat = Attributes.DEXTERITY;

    private static final CharTypes rangerType = CharTypes.RANGER;
    private static final List<WeaponType> allowedWeaponTypes = List.of(WeaponType.BOW);
    private static final List <ArmorType> allowedArmorTypes = List.of(ArmorType.LEATHER,ArmorType.MAIL);

    public Ranger(String name) {
        super(name, startingAttributes, rangerType, primeStat);
    }

    @Override
    public void levelUp() {
        super.incrementAttributes(levelUpAttributes);
        this.level = this.level + 1;
    }

    @Override
    public boolean equip(ItemInterface itemInterface) throws InvalidItemException {

        var itemSubType = armorOrWeapon(itemInterface);

        if (allowedArmorTypes.contains(itemSubType)||allowedWeaponTypes.contains(itemSubType))
            return super.equip(itemInterface.getSlot(), itemInterface);

        throw new InvalidItemException("invalid" + itemInterface.getSlot() + "equipped");
    }

}


