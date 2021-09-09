package Characters.CharacterTypes;
import Characters.Character;
import Enums.CharTypes;
import Items.ItemInterface;

public class Ranger extends Character {
    private static final int[] startingAttributes = {8, 1, 7, 1};
    private static final CharTypes ranger = CharTypes.RANGER;

    public Ranger(String name) {
        super(name, startingAttributes, ranger);
    }


    @Override
    public void levelUp() {
        this.incrementAttributes(new int[]{2, 1, 5, 1});
        this.level=this.level+1;
    }
}
