package Items;

import Enums.ArmorType;
import Enums.Slot;

public class Body implements ItemInterface, ArmorInterface {

    @Override
    public ArmorType getArmorType() {
        return armorType;
    }

    @Override
    public String getItemName() {
        return name;
    }

    @Override
    public int getLevelReq() {
        return 0;
    }

    @Override
    public Slot getSlot() {
        return bodySlot;
    }

    public Body(String name, ArmorType armorType, int levelReq) {
        this.name = name;
        this.armorType = armorType;
        this.levelReq = levelReq;
    }

    private String name;
    private Slot bodySlot = Slot.BODY;
    private ArmorType armorType;
    private int levelReq;
}
