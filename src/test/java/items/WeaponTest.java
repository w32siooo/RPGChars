package items;

import characters.charactertypes.Warrior;
import characters.InvalidItemException;
import enums.ArmorType;
import enums.Slot;
import enums.WeaponType;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {

    @org.junit.jupiter.api.Test
    void equipWeaponThatFits() {
        // Arrange
        String itemName = "Common Axe";
        int damage = 1;
        double attackSpeed = 1.0;
        int levelReq = 1;
        WeaponType axe = WeaponType.AXE;
        ItemInterface testWeapon = new Weapon(itemName, attackSpeed, damage, levelReq, axe);
        String characterName = "Gjunhildur";
        Warrior warrior = new Warrior(characterName);

        // Act
        try {
            warrior.equip(testWeapon);
        } catch (InvalidItemException e) {
            e.printStackTrace();
        }
        Weapon weapon = (Weapon) warrior.getEquipment().get(Slot.WEAPON);

        // Assert
        assertEquals(testWeapon, weapon, "Verify that weapon is equipped.");

    }

    @org.junit.jupiter.api.Test
    void equipWeaponThatDoesntFit() {
        // Arrange
        int damage = 1;
        double attackSpeed = 1.0;
        int levelReq = 1;
        String itemName = "Common Axe";
        WeaponType axe = WeaponType.STAFF;
        ItemInterface testWeapon = new Weapon(itemName, attackSpeed, damage, levelReq, axe);
        String characterName = "Gjunhildur";
        Warrior warrior = new Warrior(characterName);

        // Act
        try {
            warrior.equip(testWeapon);
        } catch (InvalidItemException e) {
            e.printStackTrace();
        }
        Weapon equippedWeapon = (Weapon) warrior.getEquipment().get(Slot.WEAPON);

        // Assert
        assertNull(equippedWeapon, "Verify that weapon is not equipped.");
        InvalidItemException thrown = assertThrows(
                InvalidItemException.class,
                () -> warrior.equip(testWeapon),
                "Expected warrior.equip(testWeapon) to throw, because warrior can't equip STAFF."
        );

        assertTrue(thrown.getMessage().contains("invalidWEAPONequipped"));
    }

    @org.junit.jupiter.api.Test
    void equipFittingArmor() {
        // Arrange
        String characterName = "Gjunhildur";
        Warrior warrior = new Warrior(characterName);
        int levelReq = 1;
        int bonusStr = 1;
        int bonusVit = 0;
        int bonusDex = 0;
        int bonusInt = 0;
        String plateArmorName = "Basic Plate Armor";
        ArmorType plateArmorType = ArmorType.PLATE;

        Body testPlateBody = new Body(plateArmorName, plateArmorType, levelReq, bonusStr, bonusVit, bonusDex, bonusInt);

        // Act
        try {
            warrior.equip(testPlateBody);
        } catch (InvalidItemException e) {
            e.printStackTrace();
        }

        // Assert
        assertEquals(testPlateBody, warrior.getEquipment().get(Slot.BODY), "should fail because warrior can't equip cloth!");

    }

    @org.junit.jupiter.api.Test
    void equipNonFittingArmor() {
        // Arrange
        String characterName = "Gjunhildur";
        Warrior warrior = new Warrior(characterName);
        String clothArmorName = "Basic Cloth Armor";
        int levelReq = 1;
        int bonusStr = 1;
        int bonusVit = 0;
        int bonusDex = 0;
        int bonusInt = 0;
        ArmorType clothArmorType = ArmorType.CLOTH;

        Body testClothBody = new Body(clothArmorName, clothArmorType, levelReq, bonusStr, bonusVit, bonusDex, bonusInt);

        // Act
        try {
            warrior.equip(testClothBody);
        } catch (InvalidItemException e) {
            e.printStackTrace();
        }
        ArmorInterface equippedBody = (ArmorInterface) warrior.getEquipment().get(Slot.BODY);

        // Assert
        assertNull(equippedBody, "should fail because warrior can't equip cloth!");

        InvalidItemException thrown = assertThrows(
                InvalidItemException.class,
                () -> warrior.equip(testClothBody),
                "Expected warrior.equip(testClothBody) to throw, because warrior can't equip cloth."
        );

        assertTrue(thrown.getMessage().contains("invalidBODYequipped"));

    }

}
