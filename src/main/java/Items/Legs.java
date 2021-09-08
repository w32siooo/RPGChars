package Items;

import Enums.ArmorType;
import Enums.ItemType;
import Enums.Slot;

public class Legs extends Item implements Armor{
    private ArmorType armorType;
    public Legs(ItemType itemType, String name, int levelReq, Slot slot, ArmorType armorType) {
        super(itemType, name, levelReq, slot);
    }

    @Override
    public ArmorType getArmorType() {
        return armorType;
    }

    @Override
    public int getDamage() {
        return 0;
    }
}
