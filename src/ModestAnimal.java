public abstract class ModestAnimal extends Animal {
    public ModestAnimal(String name, int fullSizeFrom, int fullSizeTo) {
        super(name, fullSizeFrom, fullSizeTo);
    }

    @Override
    public boolean eat(int food) {
        if (this.curEaten >= this.curFullSize) { return false; }
        if (this.curEaten + food >= this.curFullSize) {
            this.curEaten = this.curFullSize;
        }
        this.curEaten += food;
        return true;
    }
}
