package Items;

import Enums.Slot;
import Enums.Type;

public class Weapon extends Item{
    public Weapon(Type type, String name, int levelReq, Slot slot) {
        super(type, name, levelReq, slot);
    }
}
