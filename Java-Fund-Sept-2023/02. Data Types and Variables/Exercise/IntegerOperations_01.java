package data_types_and_variables_exercise;

import java.util.Scanner;
public class IntegerOperations_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());
        int number3 = Integer.parseInt(scanner.nextLine());
        int number4 = Integer.parseInt(scanner.nextLine());

        System.out.println(((number1 + number2) / number3) * number4);
    }
}
