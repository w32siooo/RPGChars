package Items;

import Enums.ItemType;
import Enums.Slot;

public class Weapon extends Item {
    private int damage;
    private double attackSpeed;
    private static final ItemType weaponType = ItemType.WEAPON;
    private static final Slot weaponSlot = Slot.WEAPON;

    public Weapon(String name, int levelReq, int damage, double attackSpeed) {
        super(weaponType, name, levelReq, weaponSlot);
        this.damage = damage;
        this.attackSpeed = attackSpeed;
    }

    public int getDamage() {
        return damage;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }
}
