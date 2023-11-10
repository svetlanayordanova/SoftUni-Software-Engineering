package mid_exam_preparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> sequence = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        int countMoves = 0;

        while (!command.equals("end")) {
            int index1 = Integer.parseInt(command.split(" ")[0]);
            int index2 = Integer.parseInt(command.split(" ")[1]);

            if ((index1 == index2) || (index1 < 0 || index1 >= sequence.size()) || (index2 < 0 || index2 >= sequence.size())) {
                countMoves++;

                int middleIndex = sequence.size() / 2;

                String penaltyElement = String.format("-%da", countMoves);

                sequence.add(middleIndex, penaltyElement);
                sequence.add(middleIndex + 1, penaltyElement);

                System.out.println("Invalid input! Adding additional elements to the board");
            } else {
                countMoves++;
                String firstElement = sequence.get(index1);
                String secondElement = sequence.get(index2);

                if (firstElement.equals(secondElement)) {
                    System.out.printf("Congrats! You have found matching elements - %s!%n", firstElement);

                    sequence.remove(firstElement);
                    sequence.remove(secondElement);
                } else {
                    System.out.println("Try again!");
                }

                if (sequence.size() == 0) {
                    System.out.printf("You have won in %d turns!", countMoves);
                    return;
                }
            }

            command = scanner.nextLine();
        }

        System.out.println("Sorry you lose :(");
        System.out.println(String.join(" ", sequence));
    }
}