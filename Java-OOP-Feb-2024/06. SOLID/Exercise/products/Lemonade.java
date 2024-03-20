package solid_exercise.products;

public class Lemonade implements Product, Drink {

    public static final double CALORIES_PER_100_GRAMS = 53.0;
    public static final double DENSITY = 0.7;

    private double milliliters;

    public Lemonade(double milliliters) {
        this.milliliters = milliliters;
    }

    public double getMilliliters() {
        return milliliters;
    }

    @Override
    public double amountOfCalories() {
        return Lemonade.CALORIES_PER_100_GRAMS / 100 * (getMilliliters() * DENSITY);
    }

    @Override
    public double amountOfDrink() {
        return getMilliliters() / 1000;
    }
}
