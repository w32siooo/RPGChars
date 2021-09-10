package Items;

import Characters.CharacterTypes.Warrior;
import Enums.ArmorType;
import Enums.Slot;
import Enums.WeaponType;

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
        Weapon expected = (Weapon) warrior.equip(testWeapon); //Expected
        Weapon weapon = (Weapon) warrior.getEquipment().get(Slot.WEAPON);

        // Assert
        assertEquals(expected, weapon, "Verify that weapon is equipped.");

        Body testClothBody = new Body("Cloth Armor", ArmorType.CLOTH, 1, 5, 4, 3, 2);
        warrior.equip(testClothBody);
        assertNotEquals(testClothBody, warrior.getEquipment().get(Slot.BODY), "should fail because warrior can't equip cloth!");
        assertEquals(3, Math.ceil(warrior.calculateDps()));
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
        warrior.equip(testWeapon);
        Weapon equippedWeapon = (Weapon) warrior.getEquipment().get(Slot.WEAPON);

        // Assert
        assertNull(equippedWeapon, "Verify that weapon is not equipped.");
    }

    @org.junit.jupiter.api.Test
    void equipFittingArmor(){
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
        warrior.equip(testPlateBody);

        // Assert
        assertEquals(testPlateBody, warrior.getEquipment().get(Slot.BODY), "should fail because warrior can't equip cloth!");

    }

    @org.junit.jupiter.api.Test
    void equipNonFittingArmor(){
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

        Body testPlateBody = new Body(clothArmorName, clothArmorType, levelReq, bonusStr, bonusVit, bonusDex, bonusInt);

        // Act
        warrior.equip(testPlateBody);
        ArmorInterface equippedBody = (ArmorInterface) warrior.getEquipment().get(Slot.BODY);

        // Assert
        assertNull(equippedBody, "should fail because warrior can't equip cloth!");

    }

}
