package Characters.CharacterTypes;

import Characters.Character;
import Enums.CharTypes;
import Items.Item;
import Items.Weapon;

public class Mage extends Character {
    private static final int[] startingAttributes = {5, 1, 1, 8};
    private static final CharTypes mage = CharTypes.MAGE;

    public Mage(String name) {
        super(name, startingAttributes, mage);
    }

    @Override
    public boolean canEquip(Item item) {
        equip(item);
        return false;
    }

    public void levelUp() {
        this.incrementAttributes(new int[]{1, 2, 3, 4});
        this.level=this.level+1;
    }

    public static void main(String[] args) {

        Mage thaliya = new Mage("thaliya");
        thaliya.levelUp();
        thaliya.levelUp();
        thaliya.levelUp();
        System.out.println(thaliya.displayStats());
        Weapon testWeapon = new Weapon("Common Axe",1,7,1.1);
        
    }

}
