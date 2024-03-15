package inheritance_exercise.Restaurant_05.food.main_dish;

import inheritance_exercise.Restaurant_05.food.Food;

import java.math.BigDecimal;

public class MainDish extends Food {
    public MainDish(String name, BigDecimal price, double grams) {
        super(name, price, grams);
    }
}
