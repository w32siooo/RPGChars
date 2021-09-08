package Items;

import Enums.Slot;
import Enums.Type;

public abstract class Item {
    Type type;
    String name;
    int levelReq;
    Slot slot;

    public Item(Type type, String name, int levelReq, Slot slot) {
        this.type = type;
        this.name = name;
        this.levelReq = levelReq;
        this.slot = slot;

    }
}


