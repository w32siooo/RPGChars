package Characters;

import Characters.CharacterTypes.Mage;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class MageTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Mage thaliya = new Mage("Thaliya");
        assertEquals(1,thaliya.getLevel(),"Level should be 1 after initiation.");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        Mage thaliya = new Mage("Thaliya");
        thaliya=null;
        assertNull(null, (Supplier<String>) thaliya);
    }

    @org.junit.jupiter.api.Test
    void levelUp() {
        Mage thaliya = new Mage("Thaliya");
        thaliya.levelUp();
        thaliya.levelUp();
        thaliya.levelUp();
        assertEquals(4,thaliya.getLevel(),"Level should be 4 after 3 level ups.");
    }

}