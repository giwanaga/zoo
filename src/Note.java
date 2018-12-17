import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;

public class Note {
    private Map<Integer, Map<String, Integer>> lines;
    public Note() {
        this.initLines();
    }
    public void initLines() {
        this.lines = new LinkedHashMap<Integer, Map<String, Integer>>();
    }

    public void takeNote(int day, String name) {
        if (!this.lines.containsKey(day)) this.lines.put(day, new LinkedHashMap<String, Integer>());
        if (!this.lines.get(day).containsKey(name)) this.lines.get(day).put(name, 0);

        int curCount = this.lines.get(day).get(name);
        this.lines.get(day).put(name, curCount+1);
    }

    public String readLine(int day) {
        String header = "Day " + String.valueOf(day) + ": ";
        if (!this.lines.containsKey(day)) return header + "INVALID DATE";

        List<String> body = new ArrayList<String>();
        this.lines.get(day).forEach((name,count) -> body.add(name + " " + String.valueOf(count)));
        return header + String.join(", ", body);
    }

    public String totalReport() {
        String header = "total: ";
        String body  = String.valueOf(calcTotal());
        return header + body;
    }
    
    private int calcTotal() {
        int total = 0;
        for (Map.Entry<Integer, Map<String, Integer>> dayResult : this.lines.entrySet()) {
            for (Map.Entry<String, Integer> animalResult : dayResult.getValue().entrySet()) {
                total += animalResult.getValue();
            }
        }
        return total;
    }
}
