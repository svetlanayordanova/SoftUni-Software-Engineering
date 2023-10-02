package data_types_and_variables_more_exercise;

import java.util.Scanner;
public class DecryptingMessage_05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        String message = "";

        for (int i = 1; i <= n; i++) {
            char currentSymbol = scanner.nextLine().charAt(0);
            int code = (int)currentSymbol;
            int currentLetter = key + code;
            char letter = (char)currentLetter;
            message += letter;
        }
        System.out.print(message);
    }
}
