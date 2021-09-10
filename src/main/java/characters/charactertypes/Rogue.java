package characters.charactertypes;

import characters.Character;
import enums.CharTypes;

public class Rogue extends Character {
    private static final int[] startingAttributes = {8, 2, 6, 1};
    private static final int[] levelUpAttributes = {3, 1, 4, 1};

    private static final CharTypes rogueType = CharTypes.ROGUE;

    public Rogue(String name) {
        super(name, startingAttributes, rogueType);
    }

    @Override
    public void levelUp() {
        super.primAttr.incrementAttributes(levelUpAttributes);
        this.level = this.level + 1;
        super.calculateDps();
    }
}
