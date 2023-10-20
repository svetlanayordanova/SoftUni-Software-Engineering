package lists_exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays_07 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        List<String> numbers = new ArrayList<>();

        for (int i = input.size() - 1; i >= 0; i--) {
            String[] array = input.get(i).split(" ");
            for (int j = 0; j <= array.length - 1; j++) {
                if (!array[j].equals("")) {
                    numbers.add(array[j]);
                }
            }
        }

        System.out.print(String.join(" ", numbers));
    }
}