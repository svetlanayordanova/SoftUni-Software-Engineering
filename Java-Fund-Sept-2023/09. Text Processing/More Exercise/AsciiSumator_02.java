package text_processing_more_exercise;

import java.util.Scanner;

public class AsciiSumator_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String firstSymbol = scanner.nextLine();
        String secondSymbol = scanner.nextLine();
        String input = scanner.nextLine();

        int totalSum = 0;

        for (char symbol : input.toCharArray()) {
            if ((symbol > firstSymbol.charAt(0) && symbol < secondSymbol.charAt(0)) || (symbol > secondSymbol.charAt(0) && symbol < firstSymbol.charAt(0))){
                totalSum += symbol;
            }
        }

        System.out.println(totalSum);
    }
}
