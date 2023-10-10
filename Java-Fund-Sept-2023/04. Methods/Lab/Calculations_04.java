package methods;

import java.util.Scanner;
public class Calculations_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());

        switch (command) {
            case "add":
                add(firstNumber, secondNumber);
                break;
            case "multiply":
                multiply(firstNumber, secondNumber);
                break;
            case "subtract":
                subtract(firstNumber, secondNumber);
                break;
            case "divide":
                divide(firstNumber, secondNumber);
                break;
        }
    }

    public static void add(int n1, int n2) {
        System.out.println(n1 + n2);
    }

    public static void multiply(int n1, int n2) {
        System.out.println(n1 * n2);
    }

    public static void subtract(int n1, int n2) {
        System.out.println(n1 - n2);
    }

    public static void divide(int n1, int n2) {
        System.out.println(n1 / n2);
    }
}
