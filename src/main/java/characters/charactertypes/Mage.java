package characters.charactertypes;

import characters.Character;
import enums.ArmorType;
import enums.CharTypes;
import enums.WeaponType;
import exceptions.InvalidItemException;
import items.ItemInterface;

public class Mage extends Character {
    private static final int[] startingAttributes = {5, 1, 1, 8};
    private static final int[] levelUpAttributes = {3, 1, 1, 5};

    private static final CharTypes mageType = CharTypes.MAGE;

    public Mage(String name) {
        super(name, startingAttributes, mageType);
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

        if (itemSubType == ArmorType.PLATE || itemSubType == ArmorType.MAIL || itemSubType == WeaponType.AXE
                || itemSubType == WeaponType.HAMMER || itemSubType == WeaponType.SWORD)
            return super.equip(itemInterface.getSlot(), itemInterface);

        throw new InvalidItemException("invalid" + itemInterface.getSlot() + "equipped");
    }

}
