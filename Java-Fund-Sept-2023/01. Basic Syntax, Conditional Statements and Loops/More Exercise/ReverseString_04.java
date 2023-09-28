package basics_recap_more_exercise;

import java.util.Scanner;
public class ReverseString_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String reverse = "";

        for (int position = input.length() - 1; position >= 0; position--) {
            char currentSymbol = input.charAt(position);
            reverse += currentSymbol;
        }
        System.out.println(reverse);
    }
}
