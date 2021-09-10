package characters;

public class BonusAttributes {
    public BonusAttributes(int bonusVit, int bonusStr, int bonusDex, int bonusInt) {
        this.bonusVit = bonusVit;
        this.bonusStr = bonusStr;
        this.bonusDex = bonusDex;
        this.bonusInt = bonusInt;
    }

    public void updateAttributes(int bonusVit, int bonusStr, int bonusDex, int bonusInt) {
        this.bonusDex += bonusDex;
        this.bonusInt += bonusInt;
        this.bonusStr += bonusStr;
        this.bonusVit += bonusVit;
    }

    public int getBonusVit() {
        return bonusVit;
    }

    public int getBonusStr() {
        return bonusStr;
    }

    public int getBonusDex() {
        return bonusDex;
    }

    public int getBonusInt() {
        return bonusInt;
    }

    private int bonusVit = 0;
    private int bonusStr = 0;
    private int bonusDex = 0;
    private int bonusInt = 0;
}