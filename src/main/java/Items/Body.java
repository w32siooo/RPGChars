package Items;

import Enums.ArmorType;
import Enums.Slot;
import Enums.ItemType;

public class Body extends Item implements Armor{
    private ArmorType armorType;
    public Body(ItemType itemType, String name, int levelReq, Slot slot, ArmorType armorType) {
        super(itemType, name, levelReq, slot);
        this.armorType = armorType;
    }

    @Override
    public ArmorType getArmorType() {
        return armorType;
    }
}
