package solid_exercise;

import solid_exercise.products.Food;

import java.util.List;

public class Printer {
    private static final String SUM = "Sum: %f";
    private static final String AVERAGE = "Average: %f";

    Calculator calculator;

    /* private Printer() {
     }
     */

     public Printer(Calculator calculator) {
        this.calculator = calculator;
     }

    /*
     public void printSum(List<Product> products, CalorieCalculator calorieCalculator) {
        System.out.printf((SUM) + "%n", calorieCalculator.sum(products));
     }
    */

     public void printSum(List<Food> products) {
        System.out.printf((SUM) + "%n", calculator.sum(products));
     }

    /*
    public void printAverage(List<Product> products, CalorieCalculator calorieCalculator) {
        System.out.printf((AVERAGE) + "%n", calorieCalculator.average(products));
    }
    */

     public void printAverage(List<Food> products) {
        System.out.printf((AVERAGE) + "%n", calculator.average(products));
     }
}