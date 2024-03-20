package solid_exercise;

import solid_exercise.products.Food;
import solid_exercise.products.Product;

import java.util.List;

public class CalorieCalculator implements Calculator {

    @Override
    public double sum(List<Food> products) {
        return products.stream().mapToDouble(Product::amountOfCalories).sum();
    }

    @Override
    public double average(List<Food> products) {
        return sum(products) / products.size();
    }
}