package characters.charactertypes;

import characters.Character;
import enums.ArmorType;
import enums.CharTypes;
import enums.WeaponType;
import exceptions.InvalidItemException;
import items.ItemInterface;

public class Warrior extends Character {
    private static final int[] startingAttributes = {10, 5, 2, 1};
    private static final int[] levelUpAttributes = {5, 3, 2, 1};

    private static final CharTypes warriorType = CharTypes.WARRIOR;

    public Warrior(String name) {
        super(name, startingAttributes, warriorType);
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
