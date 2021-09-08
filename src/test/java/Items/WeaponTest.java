package Items;

import Characters.CharacterTypes.Sorceress;
import Characters.CharacterTypes.Warrior;
import Enums.ArmorType;
import Enums.ItemType;
import Enums.Slot;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {
    @org.junit.jupiter.api.Test
    void Weapon() {
        Weapon testWeapon = new Weapon("Common Axe",1,7,1.1);


        assertEquals(7,testWeapon.getDamage(),"damage should be 7");
        assertEquals(Slot.WEAPON,testWeapon.getSlot(),"Slot should be WEAPON");
        assertEquals(ItemType.WEAPON,testWeapon.getItemType(),"ItemType should be WEAPON");
        assertEquals(1.1,testWeapon.getAttackSpeed(),"Attackspeed should be 1.1");
        assertEquals(1,testWeapon.getLevelReq(),"damage should be 7");

    }
    @org.junit.jupiter.api.Test
    void Equip(){
        Weapon testWeapon = new Weapon("Common Axe",1,7,1.1);
        Sorceress w = new Sorceress("vos");
        w.canEquip(testWeapon);
        assertEquals(testWeapon,w.getEquipment().get(Slot.WEAPON),"Verify that weapon is equipped.");
        Head testHelmet = new Head(ItemType.ARMOR,"Plate Helmet",1,Slot.HEAD, ArmorType.PLATE);
        w.canEquip(testHelmet);
        assertNotEquals(testHelmet,w.getEquipment().get(Slot.HEAD),"should fail because sorceresses can't equip PLATE helmets!");
    }
}