package encapsulation_exercise.AnimalFarm_02;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    @Override
    public String toString() {
        return String.format("encapsulation_exercise.AnimalFarm_02.Chicken %s (age %d) can produce %.2f eggs per day.",
                this.name,
                this.age,
                this.productPerDay());
    }

    public double productPerDay() {
        return this.calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        if (this.age < 6) {
            return 2;
        } else if (this.age < 12) {
            return 1;
        }
        return 0.75;
    }

    private void setName(String name) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            // isBlank - contains whitespaces
            // name.trim().isEmpty() - обединява и isBlank
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }
}