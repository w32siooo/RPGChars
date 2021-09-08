package Items;

import Enums.ArmorType;
import Enums.ItemType;
import Enums.Slot;

public abstract class Item {
    protected ItemType itemType;
    protected String name;
    protected int levelReq;
    protected Slot slot;

    public Item(ItemType itemType, String name, int levelReq, Slot slot) {
        this.itemType = itemType;
        this.name = name;
        this.levelReq = levelReq;
        this.slot = slot;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public String getName() {
        return name;
    }

    public int getLevelReq() {
        return levelReq;
    }

    public Slot getSlot() {
        return slot;
    }
}


