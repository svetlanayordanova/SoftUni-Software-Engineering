package basics_recap;

import java.util.Scanner;
public class EvenNumber_12 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean isEvenFound = false;
        while (!isEvenFound) {
            int number = Math.abs(Integer.parseInt(scanner.nextLine()));
            if (number % 2 == 0) {
                isEvenFound = true;
                System.out.printf("The number is: %d", number);
            } else {
                System.out.println("Please write an even number.");
            }
        }
    }
}
