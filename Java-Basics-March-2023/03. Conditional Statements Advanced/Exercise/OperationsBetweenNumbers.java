import java.util.Scanner;

public class OperationsBetweenNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N1 = Integer.parseInt(scanner.nextLine());
        int N2 = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();

        double result = 0;
        String oddOrEven = "";
        boolean isN2Zero = false;

        if (operator.equals("+")) {
            result = N1 + N2;
        } else if (operator.equals("-")) {
            result = N1 - N2;
        } else if (operator.equals("*")) {
            result = N1 * N2;
        } else if (operator.equals("/")) {
            if (N2 == 0) {
                isN2Zero = true;
            } else {
                result = (N1 * 1.0) / N2;
            }
        } else if (operator.equals("%")) {
            if (N2 == 0) {
                isN2Zero = true;
            } else {
                result = N1 % N2;
            }
        }

        if (operator.equals("+") || operator.equals("-") || operator.equals("*")) {
            if (result % 2 == 0) {
                oddOrEven = "even";
            } else {
                oddOrEven = "odd";
            }
        }

        switch (operator) {
            case "+":
            case "-":
            case "*":
                System.out.printf("%d %s %d = %.0f - %s", N1, operator, N2, result, oddOrEven);
                break;
            case "/":
                if (isN2Zero) {
                    System.out.printf("Cannot divide %d by zero", N1);
                } else {
                    System.out.printf("%d %s %d = %.2f", N1, operator, N2, result);
                }
                break;
            case "%":
                if (isN2Zero) {
                    System.out.printf("Cannot divide %d by zero", N1);
                } else {
                    System.out.printf("%d %s %d = %.0f", N1, operator, N2, result);
                }
                break;
        }
    }
}
