package characters;

import characters.charactertypes.Mage;
import enums.ArmorType;
import exceptions.InvalidItemException;
import items.armors.Legs;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    @org.junit.jupiter.api.Test
    void levelUp() {
        // Arrange
        Mage thaliya = new Mage("Thaliya");

        // Act
        thaliya.levelUp();
        thaliya.levelUp();
        thaliya.levelUp();

        // Assert
        assertEquals(4, thaliya.getLevel(), "Level should be 4 after 3 level ups.");
    }

    @org.junit.jupiter.api.Test
    void getTotalAttributes() throws InvalidItemException {
        // Arrange
        Mage thaliya = new Mage("Thaliya");
        int[] a = new int[]{8, 2, 2, 13};

        // Act
        thaliya.levelUp();

        // Assert
        assertEquals(Arrays.toString(a), Arrays.toString(thaliya.returnTotalAttributes()));
    }

    @org.junit.jupiter.api.Test
    void armorAttributeTest() throws InvalidItemException {
        // Arrange
        Mage thaliya = new Mage("Thaliya");
        int[] a = new int[]{8, 2, 2, 14}; //After a level up and one bonus point of vitality.
        int levelReq = 1;
        int bonusStr = 0;
        int bonusVit = 0;
        int bonusDex = 0;
        int bonusInt = 1;
        String plateArmorName = "Basic Plate Armor";
        ArmorType plateArmorType = ArmorType.CLOTH;

        Legs testLegs = new Legs(plateArmorName, plateArmorType, levelReq, bonusStr, bonusVit, bonusDex, bonusInt);

        // Act
        thaliya.equip(testLegs);
        thaliya.levelUp();

        // Assert
        assertEquals(Arrays.toString(a), Arrays.toString(thaliya.returnTotalAttributes()));
    }

    @org.junit.jupiter.api.Test
    void printTotalStats() throws InvalidItemException {
        // Arrange
        Mage thaliya = new Mage("Thaliya");
        int[] a = new int[]{8, 2, 2, 14}; //After a level up and one bonus point of vitality.
        int levelReq = 1;
        int bonusStr = 0;
        int bonusVit = 0;
        int bonusDex = 0;
        int bonusInt = 1;
        String plateArmorName = "Basic Plate Armor";
        ArmorType plateArmorType = ArmorType.CLOTH;

        Legs testLegs = new Legs(plateArmorName, plateArmorType, levelReq, bonusStr, bonusVit, bonusDex, bonusInt);

        // Act
        thaliya.equip(testLegs);
        thaliya.levelUp();

        // Assert
        assertEquals("name: Thaliya charType: MAGE level: 2 dps: 1.13 str/vit/dex/int: [8, 2, 2, 14]PrimaryAttributes baseVit=8, baseStr=2, baseDex=2, baseInt=13", thaliya.displayStats());
    }


}