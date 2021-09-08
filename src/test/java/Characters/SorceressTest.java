package Characters;

import Characters.CharacterTypes.Sorceress;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class SorceressTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Sorceress thaliya = new Sorceress("Thaliya");
        assertEquals(1,thaliya.getLevel(),"Level should be 1 after initiation.");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        Sorceress thaliya = new Sorceress("Thaliya");
        thaliya=null;
        assertNull(null, (Supplier<String>) thaliya);
    }

    @org.junit.jupiter.api.Test
    void levelUp() {
        Sorceress thaliya = new Sorceress("Thaliya");
        thaliya.levelUp();
        thaliya.levelUp();
        thaliya.levelUp();
        assertEquals(4,thaliya.getLevel(),"Level should be 4 after 3 level ups.");
    }

}