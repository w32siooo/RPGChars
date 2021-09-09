package Items;

import Enums.Slot;

public class Weapon implements ItemInterface, WeaponInterface {

    public Weapon(String name, double attackSpeed, int damage, int levelReq) {
        this.attackSpeed = attackSpeed;
        this.damage = damage;
        this.name = name;
        this.levelReq= levelReq;
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

    private double attackSpeed;
    private int damage;
    private String name;
    private Slot slot = Slot.WEAPON;
    private int levelReq;

}
