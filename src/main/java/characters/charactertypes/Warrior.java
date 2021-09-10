package characters.charactertypes;

import characters.Character;
import enums.CharTypes;

public class Warrior extends Character {
    private static final int[] startingAttributes = {10, 5, 2, 1};
    private static final int[] levelUpAttributes = {5, 3, 2, 1};

    private static final CharTypes warriorType = CharTypes.WARRIOR;

    public Warrior(String name) {
        super(name, startingAttributes, warriorType);
    }

    @Override
    public void levelUp() {
        super.primAttr.incrementAttributes(levelUpAttributes);
        this.level = this.level + 1;
        super.calculateDps();
    }

}
