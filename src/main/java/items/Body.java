package items;

import characters.BonusAttributes;
import enums.ArmorType;
import enums.Slot;

public class Body implements ItemInterface, ArmorInterface {

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

    public Body(String name, ArmorType armorType, int levelReq, int strength, int vitality, int dexterity, int intelligence) {
        this.name = name;
        this.armorType = armorType;
        this.levelReq = levelReq;
        this.bonusAttributes = new BonusAttributes(vitality,strength,dexterity,intelligence);
    }

    private String name;
    private Slot bodySlot = Slot.BODY;
    private ArmorType armorType;
    private int levelReq;
    private BonusAttributes bonusAttributes;
}
