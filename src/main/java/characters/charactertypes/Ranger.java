package characters.charactertypes;

import characters.Character;
import enums.ArmorType;
import enums.CharTypes;
import enums.WeaponType;
import exceptions.InvalidItemException;
import items.ItemInterface;

public class Ranger extends Character {
    private static final int[] startingAttributes = {8, 1, 7, 1};
    private static final int[] levelUpAttributes = {2, 1, 5, 1};

    private static final CharTypes rangerType = CharTypes.RANGER;

    public Ranger(String name) {
        super(name, startingAttributes, rangerType);
    }

    @Override
    public void levelUp() {
        super.incrementAttributes(levelUpAttributes);
        this.level = this.level + 1;
        super.calculateDps();
    }

    @Override
    public boolean equip(ItemInterface itemInterface) throws InvalidItemException {

        var itemSubType = armorOrWeapon(itemInterface);

        if (itemSubType == ArmorType.LEATHER || itemSubType == ArmorType.MAIL || itemSubType == WeaponType.DAGGER || itemSubType == WeaponType.SWORD)
            return super.equip(itemInterface.getSlot(), itemInterface);

        throw new InvalidItemException("invalid" + itemInterface.getSlot() + "equipped");
    }

}


