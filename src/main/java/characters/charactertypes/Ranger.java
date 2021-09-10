package characters.charactertypes;

import characters.Character;
import enums.CharTypes;

public class Ranger extends Character {
    private static final int[] startingAttributes = {8, 1, 7, 1};
    private static final int[] levelUpAttributes = {2, 1, 5, 1};

    private static final CharTypes rangerType = CharTypes.RANGER;

    public Ranger(String name) {
        super(name, startingAttributes, rangerType);
    }

    @Override
    public void levelUp() {
        super.primAttr.incrementAttributes(levelUpAttributes);
        this.level = this.level + 1;
    }
}
