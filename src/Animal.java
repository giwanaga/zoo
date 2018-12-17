import java.util.Random;

public abstract class Animal {
    private String name;
    private int fullSizeFrom;
    private int fullSizeTo;
    protected int curFullSize;
    protected int curEaten;

    public Animal(String name, int fullSizeFrom, int fullSizeTo) {
        this.name = name;
        this.fullSizeFrom = fullSizeFrom;
        this.fullSizeTo = fullSizeTo;
        dailyInit();
    }

    public String getName() {
        return this.name;
    }

    public void dailyInit() {
        int offset = fullSizeTo - fullSizeFrom + 1;
        this.curFullSize = new Random().nextInt(offset) + fullSizeFrom;
        this.curEaten = 0;   
    }

    public boolean eat(int food) {
        this.curEaten += food;
        return true;
    }
}
