package vetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
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

    public Pet getOldestPet() {
        return this.data.stream().max(Comparator.comparingInt(Pet::getAge)).orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The clinic has the following patients:");
        this.data.forEach(pet -> {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(pet.getName() + " " + pet.getOwner());
        });

        return stringBuilder.toString();
    }
}
