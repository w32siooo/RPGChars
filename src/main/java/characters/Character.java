package characters;

import enums.ArmorType;
import enums.Slot;
import enums.WeaponType;
import items.ArmorInterface;
import items.ItemInterface;
import enums.CharTypes;
import items.WeaponInterface;
import util.Logger;

import java.io.IOException;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public abstract class Character {

    protected static int[] startingAttributes;
    protected EnumMap<Slot, ItemInterface> equipment = new EnumMap<>(Slot.class);
    protected BonusAttributes bonusAttr;
    protected PrimaryAttributes primAttr;
    protected CharTypes charType;
    protected int level;
    protected String name;
    protected double dps;
    Logger logger;

    protected Character(String name, int[] primaryAttributes, CharTypes charType) {
        this.name = name;
        this.level = 1;
        this.primAttr = new PrimaryAttributes(primaryAttributes[0], primaryAttributes[1], primaryAttributes[2], primaryAttributes[3]);
        this.bonusAttr = new BonusAttributes(0, 0, 0, 0);
        this.charType = charType;
    }

    public abstract void levelUp();

    public int getLevel() {
        return level;
    }

    public String displayStats() {

        StringBuilder sb = new StringBuilder();
        sb.append("name: " + name + " ");
        sb.append("charType: " + charType + " ");
        sb.append("level: " + level + " ");
        sb.append("dps: " + dps + " ");
        sb.append("str/vit/dex/int: " + Arrays.toString(returnTotalAttributes()));
        sb.append(primAttr.toString());

        return sb.toString();
    }

    public int[] returnTotalAttributes() {

        return new int[]{primAttr.getBaseStr() + bonusAttr.getBonusStr(), primAttr.getBaseVit() + bonusAttr.getBonusVit(), primAttr.getBaseDex() + bonusAttr.getBonusDex(), primAttr.getBaseInt() + bonusAttr.getBonusInt()};
    }

    public ItemInterface findType(ItemInterface itemInterface){

        return itemInterface;
    }

    public ItemInterface equip(ItemInterface itemInterface) throws InvalidItemException {
        Slot slot = itemInterface.getSlot();
        ArmorType armorType = null;
        WeaponType weaponType = null;
        boolean isArmor = false;
        if (slot != Slot.WEAPON) {
            ArmorInterface armor = (ArmorInterface) itemInterface;
            armorType = armor.getArmorType();
            isArmor = true;
        }
        else  {
            WeaponInterface weapon = (WeaponInterface) itemInterface;
            weaponType = weapon.getWeaponType();
        }

        String invalid = "invalid";
        String equipped = "equipped";
        switch (charType) {
            case WARRIOR -> {
                if (armorType == ArmorType.PLATE || armorType == ArmorType.MAIL || weaponType == WeaponType.AXE || weaponType == WeaponType.HAMMER || weaponType == WeaponType.SWORD)
                    equipment.put(slot, itemInterface);
                else {
                    throw new InvalidItemException(invalid + itemInterface.getSlot() + equipped);
                }
                if (isArmor) updateAttributes((ArmorInterface) itemInterface);
            }
            case MAGE -> {
                if (armorType == ArmorType.CLOTH || weaponType == WeaponType.STAFF || weaponType == WeaponType.WAND)
                    equipment.put(slot, itemInterface);
                else {
                    throw new InvalidItemException(invalid + itemInterface.getSlot() + equipped);
                }
                if (isArmor) updateAttributes((ArmorInterface) itemInterface);

            }
            case ROGUE -> {
                if (armorType == ArmorType.LEATHER || armorType == ArmorType.MAIL || weaponType == WeaponType.BOW)
                    equipment.put(slot, itemInterface);
                else {
                    throw new InvalidItemException(invalid + itemInterface.getSlot() + equipped);
                }
                if (isArmor) updateAttributes((ArmorInterface) itemInterface);

            }
            case RANGER -> {
                if (armorType == ArmorType.LEATHER || armorType == ArmorType.MAIL || weaponType == WeaponType.DAGGER || weaponType == WeaponType.SWORD)
                    equipment.put(slot, itemInterface);
                else {
                    throw new InvalidItemException(invalid + itemInterface.getSlot() + equipped);
                }
                if (isArmor) updateAttributes((ArmorInterface) itemInterface);

            }
        }
        return itemInterface;
    }

    //private method to update attributes, runs every time a new armor item is equipped.
    private void updateAttributes(ArmorInterface armor) {
        BonusAttributes attributes = armor.getBonusAttributes();
        bonusAttr.updateAttributes(attributes.getBonusVit(), attributes.getBonusStr(), attributes.getBonusDex(), attributes.getBonusInt());
    }

    public Map<Slot, ItemInterface> getEquipment() {
        return equipment;
    }

    public double calculateDps() {

        //Character DPS = Weapon DPS * (1 + TotalPrimaryAttribute/100)

        switch (charType) {
            case WARRIOR -> {
                if (equipment.get(Slot.WEAPON).getItemName() != null) {
                    WeaponInterface weapon = (WeaponInterface) equipment.get(Slot.WEAPON);
                    dps = weapon.getDamage() * weapon.getAttackSpeed() + (1 + (this.bonusAttr.getBonusStr() + this.primAttr.getBaseStr()) / 100.0); //damage * attackspeed + (1+primAttr/100)
                } else {
                    dps = (1 + this.primAttr.getBaseStr() / 100.0);
                }

            }
            case MAGE -> {
                if (equipment.get(Slot.WEAPON).getItemName() != null) {
                    WeaponInterface weapon = (WeaponInterface) equipment.get(Slot.WEAPON);
                    dps = weapon.getDamage() * weapon.getAttackSpeed() + (1 + (this.bonusAttr.getBonusInt() + this.primAttr.getBaseInt()) / 100.0); //damage * attackspeed + (1+primAttr/100)
                } else {
                    dps = (1 + this.primAttr.getBaseInt() / 100.0);
                }
            }
            case RANGER, ROGUE -> {
                if (equipment.get(Slot.WEAPON).getItemName() != null) {
                    WeaponInterface weapon = (WeaponInterface) equipment.get(Slot.WEAPON);
                    dps = weapon.getDamage() * weapon.getAttackSpeed() + (1 + (this.bonusAttr.getBonusDex() + this.primAttr.getBaseDex()) / 100.0); //damage * attackspeed + (1+primAttr/100)
                } else {
                    dps = (1 + this.primAttr.getBaseDex() / 100.0);
                }
            }
            default -> {
                try {
                    logger.log("Something went wrong. Perhaps a new character type wasn't implemented?");
                } catch (IOException e) {
                    e.printStackTrace();
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

