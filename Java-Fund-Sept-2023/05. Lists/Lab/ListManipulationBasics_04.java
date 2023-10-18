package lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String[] command = scanner.nextLine().split(" ");

        while (!command[0].equals("end")) {
            switch (command[0]) {
                case "Add":
                    int numberToAdd = Integer.parseInt(command[1]);
                    numbers.add(numberToAdd);
                    break;
                case "Remove":
                    int numberToRemove = Integer.parseInt(command[1]);
                    numbers.remove(Integer.valueOf(numberToRemove));
                    break;
                case "RemoveAt":
                    int index = Integer.parseInt(command[1]);
                    numbers.remove(index);
                    break;
                case "Insert":
                    int numberToInsert = Integer.parseInt(command[1]);
                    int indexToInsert = Integer.parseInt(command[2]);
                    numbers.add(indexToInsert, numberToInsert);
            }

            command = scanner.nextLine().split(" ");
        }

        for (int num : numbers) {
            System.out.printf("%d ", num);
        }
    }
}