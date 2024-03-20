package solid_exercise;

import solid_exercise.Calculator;
import solid_exercise.products.Drink;
import solid_exercise.products.Food;
import solid_exercise.products.Product;

import java.util.List;

public class QuantityCalculator implements Calculator {
    List<Food> product;

    @Override
    public double sum(List<Food> products) {
        return products.stream().mapToDouble(Food::amountOfFood).sum();
    }

    @Override
    public double average(List<Food> products) {
        return sum(products) / products.size();
    }
}