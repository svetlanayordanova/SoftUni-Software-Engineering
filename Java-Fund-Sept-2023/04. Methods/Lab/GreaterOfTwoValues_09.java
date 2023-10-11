package methods;

import java.util.Scanner;
public class GreaterOfTwoValues_09 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();

        if (type.equals("int")) {
            int firstNumber = Integer.parseInt(scanner.nextLine());
            int secondNumber = Integer.parseInt(scanner.nextLine());

            System.out.println(getMax(firstNumber, secondNumber));
        } else if (type.equals("char")) {
            char firstLetter = scanner.nextLine().charAt(0);
            char secondLetter = scanner.nextLine().charAt(0);

            System.out.println(getMax(firstLetter, secondLetter));
        } else {
            String firstStr = scanner.nextLine();
            String secondStr = scanner.nextLine();

            System.out.println(getMax(firstStr, secondStr));
        }
    }

    public static int getMax(int firstNumber, int secondNumber) {
        if (firstNumber > secondNumber) {
            return firstNumber;
        }

        return secondNumber;
    }

    public static char getMax(char firstLetter, char secondLetter) {
        if (firstLetter > secondLetter) {
            return firstLetter;
        }

        return secondLetter;
    }

    public static String getMax(String firstStr, String secondStr) {
        if (firstStr.compareTo(secondStr) >= 0) {
            return firstStr;
        }

        return secondStr;
    }
}
