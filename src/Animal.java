import java.util.Random;

public abstract class Animal {
    private String name;
    private int minCapacity;
    private int maxCapacity;
    protected int curFull;
    protected int curEaten;

    public Animal(String name, int minCapacity, int maxCapacity) {
        this.name = name;
        this.minCapacity = minCapacity;
        this.maxCapacity = maxCapacity;
        dailyInit();
    }

    public String getName() {
        return this.name;
    }

    public void dailyInit() {
        int offset = maxCapacity - minCapacity + 1;
        this.curFull = new Random().nextInt(offset) + minCapacity;
        this.curEaten = 0;   
    }

    public boolean eat(int food) {
        this.curEaten += food;
        return true;
    }
}
