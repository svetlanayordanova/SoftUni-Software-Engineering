package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.data.size() < this.capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        for (Pet pet : this.data) {
            if (pet.getName().equals(name)) {
                return this.data.remove(pet);
            }
        }

        return false;
    }

    public Pet getPet(String name, String owner) {
        return this.data.stream().filter(pet -> pet.getName().equals(name) &&
                pet.getOwner().equals(owner)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The grooming salon has the following clients:").append(System.lineSeparator());
        this.data.stream().forEach(pet -> stringBuilder.append(pet.getName() + " ").append(pet.getOwner()).append(System.lineSeparator()));
        return stringBuilder.toString();
    }
}