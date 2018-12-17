public class Feeder {
    private Note note;

    public Feeder() {
        this.note = new Note();
    }

    public void feed(int day, Animal animal) {
        if (animal instanceof AnswerableAnimal) {
            while (isHungry((AnswerableAnimal) animal)) {
                feedAbit(day, animal);
            }
        } else if (animal instanceof ModestAnimal) {
            while (feedAbit(day, animal)) {}
        } else {
            System.out.println("[DEBUG] " + animal.getName() + " is a dumb greedy Animal.");
        }
    }

    private boolean isHungry(AnswerableAnimal animal) {
        if (animal instanceof Dog) return "Wooo".equals(animal.answer());
        if (animal instanceof Cat) return "Fooo".equals(animal.answer());
        return false;
    }

    private boolean feedAbit(int day, Animal animal) {
        boolean result =  animal.eat(1);
        if (result) takeNote(day, animal);
        return result;
    }
    
    private void takeNote(int day, Animal animal) {
        this.note.takeNote(day, animal.getName());
    }

    public void greeting() {
        System.out.println("welcome to the zoo!");
    }
    public void dailyReport(int day) {
        System.out.println(this.note.readLine(day));
    }
    public void totalReport() {
        System.out.println(this.note.totalReport());
    }
}
