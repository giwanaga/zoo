import java.util.Arrays;
import java.util.List;

public class Zoo {
    public static void main (String[] args) {
        System.out.println("welcome to the zoo!");

        // init
        Dog jeff = new Dog("Jeff", 7, 9);
        Cat beth = new Cat("Beth", 3, 4);
        Dog tom  = new Dog("Tom", 5, 7);
        Snake billy = new Snake("Billy", 2, 2);
        List<Animal> animals = Arrays.asList(jeff, beth, tom, billy);

        Feeder feeder = new Feeder();

        // operation
        for (int day=1; day <= 5; day++) {
            for (Animal animal : animals) {
                animal.dailyInit();
                feeder.feed(day, animal);
            }
            feeder.dailyReport(day);
        }
        feeder.totalReport();
    }
}
