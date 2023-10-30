package lists_more_exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TakeSkipRope_03 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split(""))
                .collect(Collectors.toList());

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i <= input.size() - 1; i++) {
            String currentElement = input.get(i);
            char currentSymbol = currentElement.charAt(0);

            if (currentSymbol >= 48 && currentSymbol <= 57) {
                int currentNumber = Integer.parseInt(String.valueOf(currentSymbol));
                numbers.add(currentNumber);
                input.remove(i);
                i--;
            }
        }

        //съхраняваме всички числа на четни индекси
        List<Integer> takeList = new ArrayList<>();
        //съхраняваме всички числа на нечетни индекси
        List<Integer> skipList = new ArrayList<>();

        for (int i = 0; i <= numbers.size() - 1; i++) {
            if (i % 2 == 0) {
                takeList.add(numbers.get(i));
            } else {
                skipList.add(numbers.get(i));
            }
        }

        List<String> result = new ArrayList<>();

        int takeListIndex = 0;
        int skipListIndex = 0;

        while (takeListIndex < takeList.size() && skipListIndex < skipList.size()) {
            int takeCount = takeList.get(takeListIndex);
            int skipCount = skipList.get(skipListIndex);

            if (takeCount > input.size()) {
                takeCount = input.size();
            }

            if (skipCount > input.size()) {
                skipCount = input.size();
            }

            for (int i = 0; i < takeCount; i++) {
                result.add(input.get(i));
                input.remove(i);
                i--;
                takeCount--;
            }

            if (input.size() == 0) {
                break;
            }

            for (int i = 0; i < skipCount; i++) {
                input.remove(i);
                i--;
                skipCount--;
            }

            takeListIndex++;
            skipListIndex++;
        }

        for (String item : result) {
            System.out.print(item + "");
        }
    }
}