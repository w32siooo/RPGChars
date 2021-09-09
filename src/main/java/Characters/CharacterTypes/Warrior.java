package Characters.CharacterTypes;

import Characters.Character;
import Enums.CharTypes;
import Items.ItemInterface;

public class Warrior extends Character  {
    private static final int[] startingAttributes = {10, 5, 2, 1};
    private static final CharTypes Warrior = CharTypes.WARRIOR;

    public Warrior(String name) {
        super(name, startingAttributes, Warrior);
    }

    public void levelUp() {
        this.incrementAttributes(new int[]{5, 3, 2, 1});
        this.level = this.level + 1;
    }

}
