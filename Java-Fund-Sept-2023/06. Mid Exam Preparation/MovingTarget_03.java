package mid_exam_preparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> targets = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            if (command.contains("Shoot")) {
                int shotIndex = Integer.parseInt(command.split(" ")[1]);
                int power = Integer.parseInt(command.split(" ")[2]);

                if (shotIndex >= 0 && shotIndex < targets.size()) {
                    targets.set(shotIndex, targets.get(shotIndex) - power);

                    if (targets.get(shotIndex) <= 0) {
                        targets.remove(shotIndex);
                    }
                }
            } else if (command.contains("Add")) {
                int index = Integer.parseInt(command.split(" ")[1]);
                int value = Integer.parseInt(command.split(" ")[2]);

                if (index >= 0 && index < targets.size()) {
                    targets.add(index, value);
                } else {
                    System.out.println("Invalid placement!");
                }
            } else if (command.contains("Strike")) {
                int strikeIndex = Integer.parseInt(command.split(" ")[1]);
                int radius = Integer.parseInt(command.split(" ")[2]);

                if (strikeIndex - radius >= 0 && strikeIndex + radius <= targets.size()) {
                    targets.subList(strikeIndex - radius, strikeIndex + radius + 1).clear();
                } else {
                    System.out.println("Strike missed!");
                }
            }

            command = scanner.nextLine();
        }

        System.out.println(String.join("|", targets.stream()
                .map(String::valueOf)
                        .toArray(String[]::new)));
    }
}