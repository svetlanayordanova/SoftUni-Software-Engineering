package mid_exam_preparation;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        double averageSum = sum * 1.0 / numbers.size();

        List<Integer> topIntegers = new ArrayList<>();

        for (int number : numbers) {
            if (number > averageSum) {
                topIntegers.add(number);
            }
        }

        if (topIntegers.size() == 0) {
            System.out.println("No");
        } else if (topIntegers.size() < 5) {
            for (int topNumber : topIntegers) {
                System.out.printf("%d ", topNumber);
            }
        } else {
            topIntegers = topIntegers.stream().limit(5).collect(Collectors.toList());

            for (int topNumber : topIntegers) {
                System.out.printf("%d ", topNumber);
            }
        }
    }
}