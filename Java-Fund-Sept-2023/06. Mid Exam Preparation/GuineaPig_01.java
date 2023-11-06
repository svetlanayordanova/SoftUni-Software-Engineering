package mid_exam_preparation;

import java.util.Scanner;
public class GuineaPig_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double foodInGrams = Double.parseDouble(scanner.nextLine()) * 1000;
        double hayInGrams = Double.parseDouble(scanner.nextLine()) * 1000;
        double coverInGrams = Double.parseDouble(scanner.nextLine()) * 1000;
        double guineaWeightInGrams = Double.parseDouble(scanner.nextLine()) * 1000;

        for (int day = 1; day <= 30; day++) {
            foodInGrams -= 300;

            if (day % 2 == 0) {
                hayInGrams -= foodInGrams * 0.05;
            }

            if (day % 3 == 0) {
                coverInGrams -= guineaWeightInGrams / 3;
            }

            if (foodInGrams <= 0 || hayInGrams <= 0 || coverInGrams <= 0) {
                System.out.println("Merry must go to the pet store!");
                return;
            }
        }

        System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.", foodInGrams / 1000, hayInGrams / 1000, coverInGrams / 1000);
    }
}