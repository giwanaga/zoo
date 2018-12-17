public abstract class AnswerableAnimal extends Animal{
    private String hungry;
    private String full;
    
    public AnswerableAnimal(String name, int fullSizeFrom, int fullSizeTo, String hungry, String full) {
        super(name, fullSizeFrom, fullSizeTo);
        this.hungry = hungry;
        this.full = full;
    }

    public String answer() {
        return (this.curEaten < this.curFullSize) ? hungry : full;
    }
}
