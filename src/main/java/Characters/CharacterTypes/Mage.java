package Characters.CharacterTypes;

import Characters.Character;
import Enums.CharTypes;
import Items.ItemInterface;
import Items.Weapon;

public class Mage extends Character {
    private static final int[] startingAttributes = {5, 1, 1, 8};
    private static final CharTypes mage = CharTypes.MAGE;

    public Mage(String name) {
        super(name, startingAttributes, mage);
    }

    @Override
    public void levelUp() {
        this.incrementAttributes(new int[]{1, 2, 3, 4});
        this.level=this.level+1;
        int i =5;
        Integer.toString(5);
    }

}
