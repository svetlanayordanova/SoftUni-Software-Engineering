package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public void add(Fish fish) {
        if (this.capacity > this.getFishInPool()) {
            this.fishInPool.add(fish);
        }
    }

    public boolean remove(String name) {
        for (Fish fish : this.fishInPool) {
            if (fish.getName().equals(name)) {
                return this.fishInPool.remove(fish);
            }
        }

        return false;
    }

    public Fish findFish(String name) {
        return this.fishInPool.stream().filter(f -> f.getName().equals(name)).findFirst().orElse(null);
    }

    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Aquarium: " + this.name + " ^ Size: " + this.size).append(System.lineSeparator());
        this.fishInPool.forEach(fish -> stringBuilder.append(fish.toString()).append(System.lineSeparator()));

        return stringBuilder.toString();
    }
}