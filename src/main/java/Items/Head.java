package Items;

import Enums.ArmorType;
import Enums.Slot;

public class Head implements ItemInterface, ArmorInterface {

    public Head(String name, ArmorType armorType, int levelReq) {
        this.name = name;
        this.armorType = armorType;
        this.levelReq = levelReq;
    }

    @Override
    public ArmorType getArmorType() {
        return null;
    }

    @Override
    public String getItemName() {
        return null;
    }

    @Override
    public int getLevelReq() {
        return 0;
    }

    @Override
    public Slot getSlot() {
        return null;
    }

    private String name;
    private Slot bodySlot = Slot.HEAD;
    private ArmorType armorType;
    private int levelReq;
}
