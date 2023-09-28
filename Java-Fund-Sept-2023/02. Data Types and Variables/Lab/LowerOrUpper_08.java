package data_types_and_variables;

import java.util.Scanner;
public class LowerOrUpper_08 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char character = scanner.nextLine().charAt(0);

        if (character >= 'A' && character <= 'Z') {
            System.out.println("upper-case");
        } else {
            System.out.println("lower-case");
        }
    }
}
