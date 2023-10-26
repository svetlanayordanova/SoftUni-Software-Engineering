package lists_more_exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<String> text = Arrays.stream(scanner.nextLine().split(""))
                .collect(Collectors.toList());

        int index = 0;
        String message = "";

        for (int i = 0; i <= numbers.size() - 1; i++) {
            int currentNumber = numbers.get(i);

            int sum = 0;
            int result = 0;

            while (currentNumber > 0) {
                int lastDigit = currentNumber % 10;
                sum += lastDigit;
                currentNumber /= 10;
            }

            if (sum > text.size() - 1) {
                while (sum > 0) {
                    int lastDigit = sum % 10;
                    result += lastDigit;
                    sum /= 10;
                }
                result /= 10;
                index = result;
            } else {
                index = sum;
            }

            String currentSymbol = text.get(index);
            message += currentSymbol;
            text.remove(index);
        }

        System.out.println(message);
    }
}