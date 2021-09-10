package items.armors;

import characters.BonusAttributes;
import enums.ArmorType;
import enums.Slot;
import items.ItemInterface;

public class Legs implements ItemInterface, ArmorInterface {

    public Legs(String name, ArmorType armorType, int levelReq, int strength, int vitality, int dexterity, int intelligence) {
        this.name = name;
        this.armorType = armorType;
        this.levelReq = levelReq;
        this.bonusAttributes = new BonusAttributes(vitality,strength,dexterity,intelligence);
    }

    @Override
    public ArmorType getArmorType() {
        return armorType;
    }

    @Override
    public BonusAttributes getBonusAttributes() {
        return bonusAttributes;
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
        return bodySlot;
    }

    private String name;
    private Slot bodySlot = Slot.HEAD;
    private ArmorType armorType;
    private int levelReq;
    private BonusAttributes bonusAttributes;
}