package inheritance_exercise.Restaurant_05.beverages.cold_beverage;

import inheritance_exercise.Restaurant_05.beverages.Beverage;

import java.math.BigDecimal;

public class ColdBeverage extends Beverage {
    public ColdBeverage(String name, BigDecimal price, double milliliters) {
        super(name, price, milliliters);
    }
}