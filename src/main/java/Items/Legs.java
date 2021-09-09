package Items;

import Characters.BonusAttributes;
import Enums.ArmorType;
import Enums.Slot;

public class Legs implements ItemInterface, ArmorInterface {

    public Legs(String name, ArmorType armorType, int levelReq, int strength, int vitality, int dexterity, int intelligence) {
        this.name = name;
        this.armorType = armorType;
        this.levelReq = levelReq;
        this.bonusAttributes = new BonusAttributes(vitality,strength,dexterity,intelligence);

    }

    @Override
    public ArmorType getArmorType() {
        return null;
    }

    @Override
    public BonusAttributes getBonusAttributes() {
        return bonusAttributes;
    }


    @Override
    public String getItemName() {
        return null;
    }

    @Override
    public int getLevelReq() {
        return 0;
    }

    @Override
    public Slot getSlot() {
        return null;
    }

    private String name;
    private Slot bodySlot = Slot.HEAD;
    private ArmorType armorType;
    private int levelReq;
    private BonusAttributes bonusAttributes;
}
