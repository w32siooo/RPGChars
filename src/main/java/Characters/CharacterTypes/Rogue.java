package Characters.CharacterTypes;

import Characters.Character;
import Enums.CharTypes;
import Items.ItemInterface;

public class Rogue extends Character {
    private static final int[] startingAttributes = {8, 2, 6, 1};
    private static final CharTypes rogue = CharTypes.ROGUE;

    public Rogue(String name) {
        super(name, startingAttributes, rogue);
    }

    @Override
    public void levelUp() {
        this.incrementAttributes(new int[]{3, 1, 4, 1});
        this.level = this.level + 1;
    }
}
