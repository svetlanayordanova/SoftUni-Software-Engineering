package solid_exercise.products;

public class Chips implements Product, Food {
    public static final double CALORIES_PER_100_GRAMS = 529.0;

    private double grams;

    public Chips(double grams) {
        this.grams = grams;
    }

    public double getGrams() {
        return grams;
    }

    @Override
    public double amountOfCalories() {
        return Chips.CALORIES_PER_100_GRAMS / 100 * getGrams();
    }

    @Override
    public double amountOfFood() {
        return getGrams() / 1000;
    }
}