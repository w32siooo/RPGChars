package Characters;

import Enums.Slot;
import Items.ItemInterface;
import Enums.CharTypes;
import Items.WeaponInterface;

import java.util.HashMap;

public abstract class Character {

    protected static int[] startingAttributes;
    //private TotalAttributes tot;
    protected HashMap<Slot, ItemInterface> equipment = new HashMap<>();
    protected BonusAttributes bonusAttr;
    protected PrimaryAttributes primAttr;
    protected CharTypes charType;
    protected int level;
    protected String name;
    protected double dps;

    public Character(String name, int[] primaryAttributes, CharTypes charType) {
        this.name = name;
        this.level = 1;
        this.primAttr = new PrimaryAttributes(primaryAttributes[0], primaryAttributes[1], primaryAttributes[2], primaryAttributes[3]);
        this.bonusAttr = new BonusAttributes(0,0,0,0);
        this.charType = charType;
    }

    public boolean equip(ItemInterface itemInterface) {
        equipment.put(itemInterface.getSlot(), itemInterface);
        return false;
    }

    public abstract boolean canEquip(ItemInterface itemInterface);

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

    public Boolean Equip(Slot slot, ItemInterface itemInterface) {

        equipment.put(slot, itemInterface);
        return true;
    }

    public HashMap<Slot, ItemInterface> getEquipment() {
        return equipment;
    }

    public double calculateDps() {

        //Character DPS = Weapon DPS * (1 + TotalPrimaryAttribute/100)

        switch (charType) {
            case WARRIOR -> {
                if (equipment.get(Slot.WEAPON).getItemName() != null) {
                    WeaponInterface weapon = (WeaponInterface) equipment.get(Slot.WEAPON);
                    dps = weapon.getDamage() * weapon.getAttackSpeed() + (1 + this.bonusAttr.getBonusStr() + this.primAttr.getBaseStr() / 100.0); //damage * attackspeed + (1+primAttr/100)
                } else {
                    dps = (1 + this.primAttr.getBaseStr() / 100.0);
                }

            }
            case MAGE -> {
                if (equipment.get(Slot.WEAPON).getItemName() != null) {
                    WeaponInterface weapon = (WeaponInterface) equipment.get(Slot.WEAPON);
                    dps = weapon.getDamage() * weapon.getAttackSpeed() + (1 + this.bonusAttr.getBonusInt() + this.primAttr.getBaseInt() / 100.0); //damage * attackspeed + (1+primAttr/100)
                } else {
                    dps = (1 + this.primAttr.getBaseInt() / 100.0);
                }
            }
            case RANGER, ROGUE -> {
                if (equipment.get(Slot.WEAPON).getItemName() != null) {
                    WeaponInterface weapon = (WeaponInterface) equipment.get(Slot.WEAPON);
                    dps = weapon.getDamage() * weapon.getAttackSpeed() + (1 + this.bonusAttr.getBonusDex() + this.primAttr.getBaseDex() / 100.0); //damage * attackspeed + (1+primAttr/100)
                } else {
                    dps = (1 + this.primAttr.getBaseDex() / 100.0);
                }
            }

        }

        return this.dps;
    }

    public void incrementAttributes(int[] array) {
        this.primAttr.setBaseVit(this.primAttr.getBaseVit() + array[0]);
        this.primAttr.setBaseDex(this.primAttr.getBaseDex() + array[1]);
        this.primAttr.setBaseStr(this.primAttr.getBaseStr() + array[2]);
        this.primAttr.setBaseInt(this.primAttr.getBaseInt() + array[3]);
    }
}

//this.baseVit = baseVit; this.baseStr = baseStr; this.baseDex = baseDex; this.baseInt = baseInt;