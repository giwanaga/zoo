public abstract class AnswerableAnimal extends Animal{
    private String hungry;
    private String full;
    
    public AnswerableAnimal(String name, int minCapacity, int maxCapacity, String hungry, String full) {
        super(name, minCapacity, maxCapacity);
        this.hungry = hungry;
        this.full = full;
    }

    public String answer() {
        return (this.curEaten < this.curFull) ? hungry : full;
    }
}
