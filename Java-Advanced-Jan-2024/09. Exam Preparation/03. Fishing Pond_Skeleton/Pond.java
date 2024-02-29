package fishingPond;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pond {
    //полета -> характеристики
    private int capacity;
    private List<Fish> fishes;

    //методи -> поведение
    //конструктор
    public Pond(int capacity) {
        //нов празен обект
        this.capacity = capacity;
        this.fishes = new ArrayList<>();
    }

    public void addFish(Fish fish) {
        //мога да добавям, ако текущия брой < капацитета
        //не мога да добавям, ако текущия брой >= капацитета
        if (this.fishes.size() < this.capacity) {
            this.fishes.add(fish);
        }
    }

    public boolean removeFish(String species) {
        for (Fish fish : this.fishes) {
            if (fish.getSpecies().equals(species)) {
                this.fishes.remove(fish);
                return true;
            }
        }

        //преминали сме през всички служители и не сме намерили риба от дадения вид
        return false;
    }

    public Fish getOldestFish() {
        //1 начин
        return this.fishes.stream().max(Comparator.comparingInt(Fish::getAge)).get();

        //2 начин
        /*Fish oldestFish = new Fish("", 0, ""); //най-възрастната риба
        for (Fish fish : this.fishes) {
            if (fish.getAge() > oldestFish.getAge()) {
                oldestFish = fish;
            }
        }

        return oldestFish;*/
    }

    public Fish getFish(String species) {
        for (Fish fish : this.fishes) {
            if (fish.getSpecies().equals(species)) {
                return fish;
            }
        }

        //преминали сме през всички риби и не сме намерили риба от дадения вид
        return null;
    }

    public int getCount() {
        return this.fishes.size();
    }

    public int getVacancies() {
        return this.capacity - this.fishes.size();
    }

    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fishes in the pond:").append(System.lineSeparator());
        this.fishes.forEach(f -> stringBuilder.append(f.toString()).append(System.lineSeparator()));

        return stringBuilder.toString();
    }
}