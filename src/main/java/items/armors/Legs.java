package items.armors;

import enums.ArmorType;
import enums.Attributes;
import enums.Slot;
import items.ItemInterface;

import java.util.EnumMap;
import java.util.Map;

public class Legs implements ItemInterface, ArmorInterface {

    public Legs(String name, ArmorType armorType, int levelReq, int strength, int vitality, int dexterity, int intelligence) {
        this.name = name;
        this.armorType = armorType;
        this.levelReq = levelReq;
        this.stats.put(Attributes.VITALITY,vitality);
        this.stats.put(Attributes.STRENGTH,strength);
        this.stats.put(Attributes.DEXTERITY,dexterity);
        this.stats.put(Attributes.INTELLIGENCE,intelligence);
    }

    @Override
    public ArmorType getArmorType() {
        return armorType;
    }

    @Override
    public Map getBonusAttributes() {
        return stats;
    }

    @Override
    public String getItemName() {
        return name;
    }

    @Override
    public int getLevelReq() {
        return levelReq;
    }

    @Override
    public Slot getSlot() {
        return legSlot;
    }

    private final String name;
    private final Slot legSlot = Slot.LEGS;
    private final ArmorType armorType;
    private final int levelReq;
    private final EnumMap<Attributes, Integer> stats = new EnumMap<>(Attributes.class);
}
