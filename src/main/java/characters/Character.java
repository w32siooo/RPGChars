package characters;

import enums.*;
import exceptions.InvalidItemException;
import items.armors.ArmorInterface;
import items.ItemInterface;
import items.weapons.WeaponInterface;
import util.Logger;

import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

public abstract class Character {

    protected EnumMap<Slot, ItemInterface> equipment = new EnumMap<>(Slot.class);
    protected EnumMap<Attributes, Integer> totalStats = new EnumMap<>(Attributes.class);
    protected EnumMap<Attributes, Integer> baseStats = new EnumMap<>(Attributes.class);
    protected CharTypes charType;
    protected int level;
    protected String name;
    protected double dps;
    Logger logger;

    protected Character(String name, int[] primaryAttributes, CharTypes charType) {
        this.name = name;
        this.level = 1;
        this.charType = charType;
        this.baseStats.put(Attributes.VITALITY, primaryAttributes[0]);
        this.baseStats.put(Attributes.STRENGTH, primaryAttributes[1]);
        this.baseStats.put(Attributes.DEXTERITY, primaryAttributes[2]);
        this.baseStats.put(Attributes.INTELLIGENCE, primaryAttributes[3]);
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
        sb.append(returnTotalAttributes());
        //sb.append(primAttr.toString());

        return sb.toString();
    }

    public String returnTotalAttributes() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Attributes, Integer> stat : totalStats.entrySet()) {
            sb.append(stat.getKey()).append(": ");
            sb.append(stat.getValue()).append(" ");
        }
        return sb.toString();
    }

    //Public equip method.
    public abstract boolean equip(ItemInterface itemInterface) throws InvalidItemException;

    //private equip method.
    protected boolean equip(Slot slot, ItemInterface item) throws InvalidItemException {


        //decrementstats.
        if (item.getLevelReq() > level) throw new InvalidItemException("Level too low to equip this item!");
        else {
            equipment.put(slot, item);
            if (slot != Slot.WEAPON) updateAttributes();

            calculateDps();
            return true;
        }
    }

    //private method to update attributes, runs every time a new armor item is equipped.
    private void updateAttributes() {
        //First we load up all the base stats.
        this.totalStats.put(Attributes.VITALITY,this.baseStats.get(Attributes.VITALITY));
        this.totalStats.put(Attributes.STRENGTH, this.baseStats.get(Attributes.STRENGTH));
        this.totalStats.put(Attributes.DEXTERITY, this.baseStats.get(Attributes.DEXTERITY));
        this.totalStats.put(Attributes.INTELLIGENCE, this.baseStats.get(Attributes.INTELLIGENCE));

        // Then we loop through our items and add any bonus stats found.
        StringBuilder sb = new StringBuilder();
        sb.append("items equipped are now: \n\n");
        for (Map.Entry<Slot, ItemInterface> armors : equipment.entrySet()){

            sb.append(armors.getValue().getItemName());
            if(armors.getValue().getSlot()!=Slot.WEAPON) {
                ArmorInterface armor = (ArmorInterface) armors.getValue();
                this.totalStats.put(Attributes.VITALITY, this.totalStats.get(Attributes.VITALITY) + (Integer) armor.getBonusAttributes().get(Attributes.VITALITY));
                this.totalStats.put(Attributes.STRENGTH, this.totalStats.get(Attributes.STRENGTH)+ (Integer) armor.getBonusAttributes().get(Attributes.STRENGTH));
                this.totalStats.put(Attributes.DEXTERITY, this.totalStats.get(Attributes.DEXTERITY)+ (Integer) armor.getBonusAttributes().get(Attributes.DEXTERITY));
                this.totalStats.put(Attributes.INTELLIGENCE, this.totalStats.get(Attributes.INTELLIGENCE)+ (Integer) armor.getBonusAttributes().get(Attributes.INTELLIGENCE));
            }
        }
        System.out.println(sb.toString());

    }

    public Map<Slot, ItemInterface> getEquipment() {
        return equipment;
    }

    public double calculateDps() {

        //Character DPS = Weapon DPS * as (1 + TotalPrimaryAttribute/100)

        switch (charType) {
            case WARRIOR -> {
                if (equipment.get(Slot.WEAPON) != null) {
                    WeaponInterface weapon = (WeaponInterface) equipment.get(Slot.WEAPON);
                    dps = weapon.getDamage() * weapon.getAttackSpeed() + (1 + (totalStats.get(Attributes.STRENGTH)) / 100.0);
                } else {
                    dps = (1 + baseStats.get(Attributes.STRENGTH) / 100.0);
                }

            }
            case MAGE -> {
                if (equipment.get(Slot.WEAPON) != null) {
                    WeaponInterface weapon = (WeaponInterface) equipment.get(Slot.WEAPON);
                    dps = weapon.getDamage() * weapon.getAttackSpeed() + (1 + (totalStats.get(Attributes.INTELLIGENCE)) / 100.0);
                } else {
                    dps = (1 + baseStats.get(Attributes.INTELLIGENCE) / 100.0);
                }
            }
            case RANGER, ROGUE -> {
                if (equipment.get(Slot.WEAPON) != null) {
                    WeaponInterface weapon = (WeaponInterface) equipment.get(Slot.WEAPON);
                    dps = weapon.getDamage() * weapon.getAttackSpeed() + (1 + (totalStats.get(Attributes.DEXTERITY)) / 100.0);
                } else {
                    dps = (1 + baseStats.get(Attributes.DEXTERITY) / 100.0);
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

    public static Object armorOrWeapon(ItemInterface itemInterface) {
        Slot slot = itemInterface.getSlot();
        if (slot != Slot.WEAPON) {
            ArmorInterface armor = (ArmorInterface) itemInterface;
            return armor.getArmorType();
        } else {
            WeaponInterface weapon = (WeaponInterface) itemInterface;
            return weapon.getWeaponType();
        }
    }

    protected void incrementAttributes(int[] levelUpAttributes) {

        this.baseStats.put(Attributes.VITALITY, levelUpAttributes[0] + this.baseStats.get(Attributes.VITALITY));
        this.baseStats.put(Attributes.STRENGTH, levelUpAttributes[1] + this.baseStats.get(Attributes.STRENGTH));
        this.baseStats.put(Attributes.DEXTERITY, levelUpAttributes[2] + this.baseStats.get(Attributes.DEXTERITY));
        this.baseStats.put(Attributes.INTELLIGENCE, levelUpAttributes[3] + this.baseStats.get(Attributes.INTELLIGENCE));
    }
}

