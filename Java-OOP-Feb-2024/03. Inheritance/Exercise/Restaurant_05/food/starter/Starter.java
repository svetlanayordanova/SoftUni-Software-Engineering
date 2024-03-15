package inheritance_exercise.Restaurant_05.food.starter;

import inheritance_exercise.Restaurant_05.food.Food;

import java.math.BigDecimal;

public class Starter extends Food {
    public Starter(String name, BigDecimal price, double grams) {
        super(name, price, grams);
    }
}
