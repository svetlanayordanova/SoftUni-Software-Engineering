package data_types_and_variables;

import java.util.Scanner;
public class CharsToString_06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char first = scanner.nextLine().charAt(0);
        char second = scanner.nextLine().charAt(0);
        char third = scanner.nextLine().charAt(0);

        System.out.println(first + "" + second + "" + third);
    }
}
