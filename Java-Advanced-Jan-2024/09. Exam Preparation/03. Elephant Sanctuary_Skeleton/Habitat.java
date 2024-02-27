import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Habitat {
    private List<Elephant> data;
    private int capacity;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getAllElephants() {
        return this.data.size();
    }

    public void add(Elephant elephant) {
        if (this.data.size() < this.capacity) {
            this.data.add(elephant);
        }
    }

    public boolean remove(String name) {
        for (Elephant elephant : this.data) {
            if (elephant.getName().equals(name)) {
                this.data.remove(elephant);
                return true;
            }
        }

        return false;
    }

    public Elephant getElephant(String retiredFrom) {
        return this.data.stream().filter(e -> e.getRetiredFrom().equals(retiredFrom)).findFirst().orElse(null);
    }

    public Elephant getOldestElephant() {
        return this.data.stream().max(Comparator.comparingInt(Elephant::getAge)).orElse(null);
    }

    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Saved elephants in the park:").append(System.lineSeparator());
        this.data.forEach(e -> stringBuilder.append(e.getName()).append(" came from: ").append(e.getRetiredFrom()).append(System.lineSeparator()));

        return stringBuilder.toString();
    }
}