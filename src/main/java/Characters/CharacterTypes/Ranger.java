package Characters.CharacterTypes;
import Characters.Character;
import Items.Item;

public class Ranger extends Character {
    private static final int[] startingAttributes = {8, 1, 7, 1};
    private static final String type = "Ranger";

    public Ranger(String name) {
        super(name, startingAttributes, type);
    }

    @Override
    public boolean canEquip(Item item) {
        return false;
    }

    @Override
    public void levelUp() {
        this.incrementAttributes(new int[]{2, 1, 5, 1});
        this.level=this.level+1;
    }
}
