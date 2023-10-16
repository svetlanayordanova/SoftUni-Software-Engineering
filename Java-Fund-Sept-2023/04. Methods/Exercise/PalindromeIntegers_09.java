package methods_exercise;

import java.util.Scanner;
public class PalindromeIntegers_09 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String firstNum = "";
        String secondNum = "";

        while (!input.equals("END")) {

            for (int i = 0; i <= input.length() - 1; i++) {
                char currentSymbol = input.charAt(i);
                firstNum = currentSymbol + "";
            }

            for (int j = input.length() - 1; j >= 0; j--) {
                char currentSymbol = input.charAt(j);
                secondNum = currentSymbol + "";
            }

            System.out.println(checkIsPalindrome(firstNum, secondNum));

            input = scanner.nextLine();
        }
    }

    public static boolean checkIsPalindrome(String firstNum, String secondNum) {
        if (firstNum.equals(secondNum)) {
            return true;
        } else {
            return false;
        }
    }
}