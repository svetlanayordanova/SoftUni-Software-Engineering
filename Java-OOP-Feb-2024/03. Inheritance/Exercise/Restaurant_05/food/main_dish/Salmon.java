package inheritance_exercise.Restaurant_05.food.main_dish;

import java.math.BigDecimal;

public class Salmon extends MainDish {
    private static final double SALMON_GRAMS = 22;

    public Salmon(String name, BigDecimal price) {
        super(name, price, SALMON_GRAMS);
    }
}