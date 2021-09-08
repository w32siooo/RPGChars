package Items;

import Enums.ItemType;
import Enums.Slot;
import Enums.ArmorType;

public class Head extends Item implements Armor{
    private ArmorType armorType;
    public Head(ItemType itemType, String name, int levelReq, Slot slot, ArmorType armorType) {
        super(itemType, name, levelReq, slot);
        this.armorType = armorType;
    }

    @Override
    public ArmorType getArmorType() {
        return armorType;
    }
}
