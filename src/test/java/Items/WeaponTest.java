package Items;

import Characters.CharacterTypes.Warrior;
import Enums.ArmorType;
import Enums.Slot;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {
    @org.junit.jupiter.api.Test
    void Weapon() {
        Weapon testWeapon = new Weapon("Common Axe", 1.1, 7, 1);

        assertEquals(7, testWeapon.getDamage(), "damage should be 7");
        assertEquals(Slot.WEAPON, testWeapon.getSlot(), "Slot should be WEAPON");
        assertEquals(1.1, testWeapon.getAttackSpeed(), "Attack speed should be 1.1");
        assertEquals(1, testWeapon.getLevelReq(), "damage should be 7");

    }

    @org.junit.jupiter.api.Test
    void Equip() {

        ItemInterface testWeapon = new Weapon("Common Axe", 1.1, 7, 1);
        Warrior w = new Warrior("vos");
        w.canEquip(testWeapon);
        assertEquals(testWeapon, w.getEquipment().get(Slot.WEAPON), "Verify that weapon is equipped.");
        Body testBody = new Body("Plate Armor", ArmorType.PLATE, 1);
        Body testBody2 = new Body("Cloth Armor", ArmorType.CLOTH, 1);
        w.canEquip(testBody);
        w.canEquip(testBody2);
        assertEquals(testBody2, w.getEquipment().get(Slot.BODY), "should fail because mage can't equip PLATE!");
        assertEquals(8.75, Math.round(w.calculateDps()), 2);
    }
}