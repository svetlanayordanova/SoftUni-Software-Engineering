package solid_exercise;

import solid_exercise.products.Food;

import java.util.List;

public interface Calculator {
    double sum(List<Food> products);
    double average(List<Food> products);
}
