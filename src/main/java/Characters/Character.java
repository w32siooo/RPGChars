package Characters;
import Enums.Slot;
import Items.Item;

import java.util.HashMap;

public abstract class Character {

    //private TotalAttributes tot;
    private HashMap<Slot, Item> Equipment;

    public Character(String name, int[] primaryAttributes, String type) {
        this.name = name;
        this.level = 1;
        this.primAttr = new PrimaryAttributes(primaryAttributes[0], primaryAttributes[1], primaryAttributes[2], primaryAttributes[3]);
        this.type = type;
    }

    public abstract void levelUp();

    public int getLevel() {
        return this.level;
    }

    public String displayStats(){

        StringBuilder sb = new StringBuilder();
        sb.append("name: " + name+" ");
        sb.append("type: " + type+" ");
        sb.append("level: " + level+" ");
        //sb.append("dps: " + dps+" ");
        //sb.append(totAttr.toString());
        sb.append(primAttr.toString());

        return sb.toString();
    }

    public Boolean Equip(Slot slot, Item item){

        Equipment.put(slot,item);
        return true;
    }

    public HashMap<Slot,Item> getEquipment(){
        return Equipment;
    }

    public void incrementAttributes(int[] array) {
        this.primAttr.setBaseVit(this.primAttr.getBaseVit() + array[0]);
        this.primAttr.setBaseDex(this.primAttr.getBaseDex() + array[1]);
        this.primAttr.setBaseStr(this.primAttr.getBaseStr() + array[2]);
        this.primAttr.setBaseInt(this.primAttr.getBaseInt() + array[3]);
    }

    protected TotalAttributes totAttr;
    protected PrimaryAttributes primAttr;
    protected String type;
    protected int level;
    protected String name;
    protected static int[] startingAttributes;
}

//this.baseVit = baseVit; this.baseStr = baseStr; this.baseDex = baseDex; this.baseInt = baseInt;