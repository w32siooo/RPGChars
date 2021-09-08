package Characters.CharacterTypes;

import Characters.Character;
import Enums.Slot;
import Items.Item;
import Items.Weapon;

import java.util.HashMap;

public class Sorceress extends Character {
    private static final int[] startingAttributes = {5, 1, 1, 8};
    private static final String type = "Sorceress";

    public Sorceress(String name) {
        super(name, startingAttributes, type);
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

        Sorceress thaliya = new Sorceress("thaliya");
        thaliya.levelUp();
        thaliya.levelUp();
        thaliya.levelUp();
        System.out.println(thaliya.displayStats());
        Weapon testWeapon = new Weapon("Common Axe",1,7,1.1);
        
    }

}
