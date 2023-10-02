package data_types_and_variables_more_exercise;

import java.util.Scanner;
public class FloatingEquality_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double firstFloat = Double.parseDouble(scanner.nextLine());
        double secondFloat = Double.parseDouble(scanner.nextLine());
        double eps = 0.000001;

        if (Math.abs(firstFloat - secondFloat) < eps) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
