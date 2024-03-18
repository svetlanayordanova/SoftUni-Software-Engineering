package interfaces_and_abstraction_exercise.BirthdayCelebrations_03;

public class Pet implements Birthable {
    private String name;
    private String birthDate;

    public Pet(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }

    public String getName() {
        return name;
    }
}
