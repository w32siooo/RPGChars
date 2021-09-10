package characters;

import characters.charactertypes.Mage;
import enums.ArmorType;
import enums.WeaponType;
import items.Head;
import items.Weapon;

import java.util.Arrays;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Mage thaliya = new Mage("Thaliya");
        assertEquals(1, thaliya.getLevel(), "Level should be 1 after initiation.");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        Mage thaliya = new Mage("Thaliya");
        thaliya = null;
        assertNull(null, (Supplier<String>) thaliya);
    }

    @org.junit.jupiter.api.Test
    void levelUp() {
        Mage thaliya = new Mage("Thaliya");
        thaliya.levelUp();
        thaliya.levelUp();
        thaliya.levelUp();
        assertEquals(4, thaliya.getLevel(), "Level should be 4 after 3 level ups.");
    }

    @org.junit.jupiter.api.Test
    void getTotalAttributes() throws InvalidItemException {
        Mage thaliya = new Mage("Thaliya");
        assertEquals(Arrays.toString(new int[]{1, 5, 1, 8}), Arrays.toString(thaliya.returnTotalAttributes()), "basic mage has 1str 5 vit, 1dex, 8 int");
        thaliya.levelUp();
        thaliya.levelUp();
        thaliya.levelUp();
        Weapon staff = new Weapon("Staff of red", 1.5, 5, 1, WeaponType.STAFF);
        thaliya.equip(staff);
        assertEquals(Arrays.toString(new int[]{10, 8, 7, 20}), Arrays.toString(thaliya.returnTotalAttributes()));
        Head clothHead = new Head("Quilted vest", ArmorType.CLOTH, 1, 1, 5, 5, 15);
        thaliya.equip(clothHead);
        assertEquals(Arrays.toString(new int[]{11, 13, 12, 35}), Arrays.toString(thaliya.returnTotalAttributes()), "After we equip the cloth vest, stats should increase");
        assertEquals("name: Thaliya charType: MAGE level: 4 dps: 0.0 str/vit/dex/int: [11, 13, 12, 35]PrimaryAttributes baseVit=8, baseStr=10, baseDex=7, baseInt=20", thaliya.displayStats());
    }

}