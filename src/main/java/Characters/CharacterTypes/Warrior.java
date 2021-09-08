package Characters.CharacterTypes;

import Characters.Character;
import Enums.ItemType;
import Items.Item;
import Items.Weapon;

public class Warrior extends Character  {
    private static final int[] startingAttributes = {10, 5, 2, 1};
    private static final String type = "Warrior";

    public Warrior(String name) {
        super(name, startingAttributes, type);
    }

    @Override
    public boolean canEquip(Item item) {
        if (item.getItemType() == ItemType.WEAPON) {
            equip(item);
        }
        if (item.getItemType() == ItemType.ARMOR) {
            switch (item.getSlot()){
                case BODY:
                    equip(item);
                    break;
                case HEAD:
                    equip(item);
                    break;
                case LEGS:
                    equip(item);
                    break;

            }
        }
        return false;
    }

    public void levelUp() {
        this.incrementAttributes(new int[]{5, 3, 2, 1});
        this.level = this.level + 1;
    }

}
