import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;

public class Note {
    private Map<Integer, Map<String, Integer>> feedNote;
    public Note() {
        this.initialize();
    }
    public void initialize() {
        this.feedNote = new LinkedHashMap<Integer, Map<String, Integer>>();
    }

    public void takeNote(int day, String name) {
        if (!this.feedNote.containsKey(day)) {
            this.feedNote.put(day, new LinkedHashMap<String, Integer>());
        }
        Map<String, Integer> dayNote = this.feedNote.get(day);

        if (!dayNote.containsKey(name)) {
            dayNote.put(name, 0);
        }
        dayNote.put(name, dayNote.get(name)+1);
    }

    public String totalReport() {
        int total = calcTotal(this.feedNote);
        return "total: " + String.valueOf(total);
    }
    public String dailyReport(int day) {
        return "Day " + String.valueOf(day) + ": " + generateDailyReport(day);
    }
    private String generateDailyReport(int day) {
        if (!this.feedNote.containsKey(day)) return "INVALID DATE";

        List<String> dailyReport = new ArrayList<String>();
        for (Map.Entry<String, Integer> e : this.feedNote.get(day).entrySet()) {
            dailyReport.add(e.getKey() + " " + String.valueOf(e.getValue()));
        }
        return String.join(", ", dailyReport);
    }

    private int calcTotal(Map<Integer, Map<String, Integer>> feedNote) {
        int total = 0;
        for (Map.Entry<Integer, Map<String, Integer>> dayNote : feedNote.entrySet()) {
            for (Map.Entry<String, Integer> eachAnimal : dayNote.getValue().entrySet()) {
                total += eachAnimal.getValue();
            }
        }
        return total;
    }
}
