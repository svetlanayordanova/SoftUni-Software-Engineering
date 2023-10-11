package methods;

import java.text.DecimalFormat;
import java.util.Scanner;
public class MathOperations_11 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int secondNumber = Integer.parseInt(scanner.nextLine());

        System.out.println(new DecimalFormat("0.##").format(calculate(firstNumber, operator, secondNumber)));
    }

    public static double calculate(int firstNumber, String operator, int secondNumber) {
        double result = 0;

        switch (operator) {
            case "/":
                result = firstNumber * 1.0 / secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
        }

        return result;
    }
}
