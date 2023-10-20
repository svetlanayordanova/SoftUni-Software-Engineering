package lists_exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers_05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String[] input = scanner.nextLine().split(" ");
        int bombNumber = Integer.parseInt(input[0]);
        int power = Integer.parseInt(input[1]);

        while (numbers.contains(bombNumber)) {
            int bombIndex = numbers.indexOf(bombNumber);

            if (bombIndex - power < 0) {
                for (int i = 0; i < bombIndex; i++) {
                    numbers.set(i, 0);
                }
            } else {
                for (int i = bombIndex - power; i < bombIndex; i++) {
                    numbers.set(i, 0);
                }
            }

            if (bombIndex + power < numbers.size()) {
                for (int i = bombIndex; i <= bombIndex + power; i++) {
                    numbers.set(i, 0);
                }
            } else {
                for (int i = bombIndex; i <= numbers.size() - 1; i++) {
                    numbers.set(i, 0);
                }
            }
        }

        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        System.out.println(sum);
    }
}