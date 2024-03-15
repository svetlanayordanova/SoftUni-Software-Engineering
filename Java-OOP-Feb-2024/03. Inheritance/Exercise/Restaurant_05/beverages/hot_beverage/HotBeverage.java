package inheritance_exercise.Restaurant_05.beverages.hot_beverage;

import inheritance_exercise.Restaurant_05.beverages.Beverage;

import java.math.BigDecimal;

public class HotBeverage extends Beverage {
    public HotBeverage(String name, BigDecimal price, double milliliters) {
        super(name, price, milliliters);
    }
}
