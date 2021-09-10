package characters;
class PrimaryAttributes{
    private int baseVit, baseStr, baseDex, baseInt;

    public PrimaryAttributes(int baseVit, int baseStr, int baseDex, int baseInt) {
        this.baseVit = baseVit;
        this.baseStr = baseStr;
        this.baseDex = baseDex;
        this.baseInt = baseInt;
    }

    @Override
    public String toString() {
        return "PrimaryAttributes " +
                "baseVit=" + baseVit +
                ", baseStr=" + baseStr +
                ", baseDex=" + baseDex +
                ", baseInt=" + baseInt
                ;
    }

    public int getBaseVit() {
        return baseVit;
    }

    public void setBaseVit(int baseVit) {
        this.baseVit = baseVit;
    }

    public int getBaseStr() {
        return baseStr;
    }

    public void setBaseStr(int baseStr) {
        this.baseStr = baseStr;
    }

    public int getBaseDex() {
        return baseDex;
    }

    public void setBaseDex(int baseDex) {
        this.baseDex = baseDex;
    }

    public int getBaseInt() {
        return baseInt;
    }

    public void setBaseInt(int baseInt) {
        this.baseInt = baseInt;
    }
}