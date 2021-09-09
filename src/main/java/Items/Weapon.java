package Items;

import Enums.Slot;
import Enums.WeaponType;

public class Weapon implements ItemInterface, WeaponInterface {

    public Weapon(String name, double attackSpeed, int damage, int levelReq, WeaponType weaponType) {
        this.attackSpeed = attackSpeed;
        this.damage = damage;
        this.name = name;
        this.levelReq= levelReq;
        this.weaponType = weaponType;
    }

    @Override
    public String getItemName() {
        return name;
    }

    @Override
    public int getLevelReq() {
        return levelReq;
    }

    @Override
    public Slot getSlot() {
        return slot;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public double getAttackSpeed() {
        return attackSpeed;
    }

    @Override
    public WeaponType getWeaponType() {
        return weaponType;
    }

    private double attackSpeed;
    private int damage;
    private String name;
    private Slot slot = Slot.WEAPON;
    private int levelReq;
    private WeaponType weaponType;

}
