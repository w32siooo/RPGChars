package characters.charactertypes;

import characters.Character;
import enums.CharTypes;

public class Mage extends Character {
    private static final int[] startingAttributes = {5, 1, 1, 8};
    private static final int[] levelUpAttributes = {3, 1, 1, 5};

    private static final CharTypes mageType = CharTypes.MAGE;

    public Mage(String name) {
        super(name, startingAttributes, mageType);
    }

    @Override
    public void levelUp() {
        super.primAttr.incrementAttributes(levelUpAttributes);
        this.level = this.level + 1;
        super.calculateDps();
    }

}
