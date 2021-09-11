package characters.charactertypes;

import characters.Character;
import enums.ArmorType;
import enums.CharTypes;
import enums.WeaponType;
import exceptions.InvalidItemException;
import items.ItemInterface;

public class Rogue extends Character {
    private static final int[] startingAttributes = {8, 2, 6, 1};
    private static final int[] levelUpAttributes = {3, 1, 4, 1};

    private static final CharTypes rogueType = CharTypes.ROGUE;

    public Rogue(String name) {
        super(name, startingAttributes, rogueType);
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

        if (itemSubType == ArmorType.LEATHER || itemSubType == ArmorType.MAIL || itemSubType == WeaponType.BOW)
            return super.equip(itemInterface.getSlot(), itemInterface);

        throw new InvalidItemException("invalid" + itemInterface.getSlot() + "equipped");
    }
}
