package Characters;

import Enums.ItemType;
import Enums.Slot;
import Items.Item;
import Enums.CharTypes;

import java.util.HashMap;

public abstract class Character {

    protected static int[] startingAttributes;
    //private TotalAttributes tot;
    protected HashMap<Slot, Item> equipment = new HashMap<>();
    protected TotalAttributes totAttr;
    protected PrimaryAttributes primAttr;
    protected CharTypes charType;
    protected int level;
    protected String name;
    protected double dps;

    public Character(String name, int[] primaryAttributes, CharTypes charType) {
        this.name = name;
        this.level = 1;
        this.primAttr = new PrimaryAttributes(primaryAttributes[0], primaryAttributes[1], primaryAttributes[2], primaryAttributes[3]);
        this.charType = charType;
    }

    public void equip(Item item) {
        equipment.put(item.getSlot(), item);
    }

    public abstract boolean canEquip(Item item);

    public abstract void levelUp();

    public int getLevel() {
        return level;
    }

    public String displayStats() {

        StringBuilder sb = new StringBuilder();
        sb.append("name: " + name + " ");
        sb.append("charType: " + charType + " ");
        sb.append("level: " + level + " ");
        //sb.append("dps: " + dps+" ");
        //sb.append(totAttr.toString());
        sb.append(primAttr.toString());

        return sb.toString();
    }

    public Boolean Equip(Slot slot, Item item) {

        equipment.put(slot, item);
        return true;
    }

    public HashMap<Slot, Item> getEquipment() {
        return equipment;
    }

    public int calculateDps() {

        //Character DPS = Weapon DPS * (1 + TotalPrimaryAttribute/100)

        switch (charType) {
            case WARRIOR:
                if (equipment.get(Slot.WEAPON).getName() != null) {
                    this.dps = equipment.get(Slot.WEAPON).getDamage() * (1 + this.primAttr.getBaseStr());
                }
                this.dps = equipment.get(Slot.WEAPON).getDamage() * (1 + this.primAttr.getBaseStr()); //no weapon
                break;
            case MAGE:
                this.dps = equipment.get(Slot.WEAPON).getDamage() * (1 + this.primAttr.getBaseInt());
                break;
            case ROGUE:
                this.dps = equipment.get(Slot.WEAPON).getDamage() * (1 + this.primAttr.getBaseDex());
                break;
            case RANGER:
                this.dps = equipment.get(Slot.WEAPON).getDamage() * (1 + this.primAttr.getBaseDex());
                break;

        }


        return 0;
    }

    public void incrementAttributes(int[] array) {
        this.primAttr.setBaseVit(this.primAttr.getBaseVit() + array[0]);
        this.primAttr.setBaseDex(this.primAttr.getBaseDex() + array[1]);
        this.primAttr.setBaseStr(this.primAttr.getBaseStr() + array[2]);
        this.primAttr.setBaseInt(this.primAttr.getBaseInt() + array[3]);
    }
}

//this.baseVit = baseVit; this.baseStr = baseStr; this.baseDex = baseDex; this.baseInt = baseInt;