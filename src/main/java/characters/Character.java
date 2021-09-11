package characters;

import enums.*;
import exceptions.InvalidItemException;
import items.armors.ArmorInterface;
import items.ItemInterface;
import items.weapons.WeaponInterface;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public abstract class Character {

    protected EnumMap<Slot, ItemInterface> equipment = new EnumMap<>(Slot.class);
    protected EnumMap<Attributes, Integer> totalStats = new EnumMap<>(Attributes.class);
    protected EnumMap<Attributes, Integer> baseStats = new EnumMap<>(Attributes.class);
    protected List<WeaponType> allowedWeaponTypes;
    protected List<ArmorType> allowedArmorTypes;
    protected int[] levelUpAttributes;
    protected CharTypes charType;
    protected int level;
    protected String name;
    protected double dps;
    protected Attributes primaryStat;

    protected Character(String name, int[] primaryAttributes, CharTypes charType, Attributes primaryStat, int[] levelUpAttributes, List<ArmorType> allowedArmorTypes, List<WeaponType> allowedWeaponTypes) {
        this.name = name;
        this.level = 1;
        this.charType = charType;
        this.baseStats.put(Attributes.VITALITY, primaryAttributes[0]);
        this.baseStats.put(Attributes.STRENGTH, primaryAttributes[1]);
        this.baseStats.put(Attributes.DEXTERITY, primaryAttributes[2]);
        this.baseStats.put(Attributes.INTELLIGENCE, primaryAttributes[3]);
        this.primaryStat = primaryStat;
        this.allowedWeaponTypes = allowedWeaponTypes;
        this.allowedArmorTypes = allowedArmorTypes;
        this.levelUpAttributes = levelUpAttributes;
    }

    public  void levelUp(){
        level++;
        incrementAttributes();
    }

    public int getLevel() {
        return level;
    }

    public String displayStats() {

        StringBuilder sb = new StringBuilder();
        sb.append("name: " + name + " ");
        sb.append("charType: " + charType + " ");
        sb.append("level: " + level + " ");
        sb.append("dps: " + calculateDps() + " ");
        sb.append("Base stats: " + returnBaseAttributes());
        sb.append("Total stats: " + returnTotalAttributes());

        return sb.toString();
    }

    public String returnTotalAttributes() {
        return enumMapToString(totalStats);
    }

    public String returnBaseAttributes() {
        return enumMapToString(baseStats);
    }

    private String enumMapToString(EnumMap<Attributes, Integer> stats) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Attributes, Integer> stat : stats.entrySet()) {
            sb.append(stat.getKey()).append(": ");
            sb.append(stat.getValue()).append(" ");
        }
        return sb.toString();
    }

    //Public equip method.
    public boolean equip(ItemInterface itemInterface) throws InvalidItemException {

        var itemSubType = armorOrWeapon(itemInterface);

        if (allowedArmorTypes.contains(itemSubType)||allowedWeaponTypes.contains(itemSubType))
            return equip(itemInterface.getSlot(), itemInterface);

        throw new InvalidItemException("invalid" + itemInterface.getSlot() + "equipped");
    }

    //private equip method.
    protected boolean equip(Slot slot, ItemInterface item) throws InvalidItemException {

        if (item.getLevelReq() > level) throw new InvalidItemException("Level too low to equip this item!");
        else {
            equipment.put(slot, item);

            runAfterStatUpdate();
            return true;
        }
    }

    private void runAfterStatUpdate() {
        updateAttributes();
        calculateDps();
    }

    //private method to update attributes, runs every time a new armor item is equipped.
    private void updateAttributes() {
        //First we load up all the base stats.
        this.totalStats.put(Attributes.VITALITY, this.baseStats.get(Attributes.VITALITY));
        this.totalStats.put(Attributes.STRENGTH, this.baseStats.get(Attributes.STRENGTH));
        this.totalStats.put(Attributes.DEXTERITY, this.baseStats.get(Attributes.DEXTERITY));
        this.totalStats.put(Attributes.INTELLIGENCE, this.baseStats.get(Attributes.INTELLIGENCE));

        // Then we loop through our items and add any bonus stats found.
        //Items equipped are now:
        for (Map.Entry<Slot, ItemInterface> armors : equipment.entrySet()) {

            if (armors.getValue().getSlot() != Slot.WEAPON) {
                ArmorInterface armor = (ArmorInterface) armors.getValue();
                this.totalStats.put(Attributes.VITALITY, this.totalStats.get(Attributes.VITALITY) + (Integer) armor.getBonusAttributes().get(Attributes.VITALITY));
                this.totalStats.put(Attributes.STRENGTH, this.totalStats.get(Attributes.STRENGTH) + (Integer) armor.getBonusAttributes().get(Attributes.STRENGTH));
                this.totalStats.put(Attributes.DEXTERITY, this.totalStats.get(Attributes.DEXTERITY) + (Integer) armor.getBonusAttributes().get(Attributes.DEXTERITY));
                this.totalStats.put(Attributes.INTELLIGENCE, this.totalStats.get(Attributes.INTELLIGENCE) + (Integer) armor.getBonusAttributes().get(Attributes.INTELLIGENCE));
            }
        }

    }

    public Map<Slot, ItemInterface> getEquipment() {
        return equipment;
    }

    private String calculateDps() {

        if (equipment.get(Slot.WEAPON) != null) {
            WeaponInterface weapon = (WeaponInterface) equipment.get(Slot.WEAPON);
            dps = weapon.getDamage() * weapon.getAttackSpeed() + (1 + (totalStats.get(primaryStat)) / 100.0); // Dps with weapon.
        } else {
            dps = (1 + totalStats.get(primaryStat) / 100.0); // Melee dps.
        }

        dps = Math.round(dps * 100d) / 100d; // Round to 2 digits precision.


        return String.format("%.2f", dps);
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

    protected void incrementAttributes() {

        baseStats.put(Attributes.VITALITY, levelUpAttributes[0] + baseStats.get(Attributes.VITALITY));
        baseStats.put(Attributes.STRENGTH, levelUpAttributes[1] + baseStats.get(Attributes.STRENGTH));
        baseStats.put(Attributes.DEXTERITY, levelUpAttributes[2] + baseStats.get(Attributes.DEXTERITY));
        baseStats.put(Attributes.INTELLIGENCE, levelUpAttributes[3] + baseStats.get(Attributes.INTELLIGENCE));

        runAfterStatUpdate();
    }
}

