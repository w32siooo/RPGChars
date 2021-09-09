package Items;

import Characters.CharacterTypes.Warrior;
import Enums.ArmorType;
import Enums.Slot;
import Enums.WeaponType;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {
    @org.junit.jupiter.api.Test
    void Weapon() {
        Weapon testWeapon = new Weapon("Common Axe", 1.1, 7, 1,WeaponType.AXE);

        assertEquals(7, testWeapon.getDamage(), "damage should be 7");
        assertEquals(Slot.WEAPON, testWeapon.getSlot(), "Slot should be WEAPON");
        assertEquals(1.1, testWeapon.getAttackSpeed(), "Attack speed should be 1.1");
        assertEquals(1, testWeapon.getLevelReq(), "damage should be 7");

    }

    @org.junit.jupiter.api.Test
    void Equip() {

        ItemInterface testWeapon = new Weapon("Common Axe", 1.1, 7, 1, WeaponType.AXE);
        Warrior w = new Warrior("vos");
        w.equip(testWeapon);
        assertEquals(testWeapon, w.getEquipment().get(Slot.WEAPON), "Verify that weapon is equipped.");
        ItemInterface testStaff = new Weapon("Common Axe", 1.1, 7, 1, WeaponType.STAFF);
        w.equip(testStaff);
        assertNotEquals(testStaff, w.getEquipment().get(Slot.WEAPON), "warrior cant equip staff, should fail!");
        Body testPlateBody = new Body("Plate Armor", ArmorType.PLATE, 1,5,4,3,2);
        Body testClothBody = new Body("Cloth Armor", ArmorType.CLOTH, 1,5,4,3,2);
        w.equip(testPlateBody);
        assertEquals(testPlateBody, w.getEquipment().get(Slot.BODY), "should fail because warrior can't equip cloth!");
        w.equip(testClothBody);
        assertNotEquals(testClothBody, w.getEquipment().get(Slot.BODY), "should fail because warrior can't equip cloth!");
        assertEquals(9, Math.ceil(w.calculateDps()));
    }
}