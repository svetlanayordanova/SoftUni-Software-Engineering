package data_types_and_variables_more_exercise;

import java.util.Scanner;
public class BalancedBrackets_06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int openCount = 0;
        int closeCount = 0;

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();

            if (input.equals(")") && openCount == 0) {
                closeCount++;
                break;
            } else if (input.equals("(")) {
                openCount++;
                if (openCount == 2) {
                    break;
                }
            } else if (input.equals(")")) {
                closeCount++;
                if (closeCount == 2) {
                    break;
                }
            }
            if (openCount == 1 && closeCount == 1) {
                openCount = 0;
                closeCount = 0;
            }
        }

        if (openCount == closeCount) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
