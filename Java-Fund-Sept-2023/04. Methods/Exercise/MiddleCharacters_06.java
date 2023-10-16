package methods_exercise;

import java.util.Scanner;
public class MiddleCharacters_06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        printMiddleCharacter(text);
    }

    public static void printMiddleCharacter(String text) {
        int length = text.length();

        if (length % 2 != 0) {
            int indexOfMiddleCharacter = length / 2;
            System.out.println(text.charAt(indexOfMiddleCharacter));
        } else {
            int indexOfFirstMiddleCharacter = length / 2 - 1;
            System.out.print(text.charAt(indexOfFirstMiddleCharacter));
            int indexOfSecondMiddleCharacter = length / 2;
            System.out.print(text.charAt(indexOfSecondMiddleCharacter));
        }
    }
}
