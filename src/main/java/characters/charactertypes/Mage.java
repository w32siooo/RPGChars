package characters.charactertypes;

import characters.Character;
import enums.CharTypes;

public class Mage extends Character {
    private static final int[] startingAttributes = {5, 1, 1, 8};
    private static final CharTypes mageType = CharTypes.MAGE;

    public Mage(String name) {
        super(name, startingAttributes, mageType);
    }

    @Override
    public void levelUp() {
        this.incrementAttributes(new int[]{1, 2, 3, 4});
        this.level = this.level + 1;
    }

}
