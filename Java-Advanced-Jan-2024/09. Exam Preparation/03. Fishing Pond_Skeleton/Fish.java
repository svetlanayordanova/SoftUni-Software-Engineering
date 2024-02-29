package fishingPond;

public class Fish {
    private String species;
    private int age;
    private String matingSeason;

    //методи
    //конструктор -> метод, чрез който създаваме обекти от класа
    //ALT + INSERT
    public Fish(String species, int age, String matingSeason) {
        this.species = species;
        this.age = age;
        this.matingSeason = matingSeason;
    }

    //Getters & Setters
    //Getter -> взема стойност
    //Setter -> задава стойност
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMatingSeason() {
        return matingSeason;
    }

    public void setMatingSeason(String matingSeason) {
        this.matingSeason = matingSeason;
    }

    //toString -> представя всеки обект от класа под формата на текст
    @Override
    public String toString() {
        //"This {species} is {age} years old and reproduces through {matingSeason}."
        return String.format("This %s is %d years old and reproduces through %s.", this.species, this.age, this.matingSeason);
    }
}