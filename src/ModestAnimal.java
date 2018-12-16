public abstract class ModestAnimal extends Animal {
    public ModestAnimal(String name, int minCapacity, int maxCapacity) {
        super(name, minCapacity, maxCapacity);
    }

    @Override
    public boolean eat(int food) {
        if (this.curEaten >= this.curFull) { return false; }
        if (this.curEaten + food >= this.curFull) {
            this.curEaten = this.curFull;
        }
        this.curEaten += food;
        return true;
    }
}
