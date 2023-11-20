package mid_exam_preparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> chest = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Yohoho!")) {
            if (command.contains("Loot")) {

                List<String> loots = Arrays.stream(command.split(" "))
                        .collect(Collectors.toList());

                loots.remove(0);

                for (String loot : loots) {
                    if (!chest.contains(loot)) {
                        chest.add(0, loot);
                    }
                }
            } else if (command.contains("Drop")) {
                int index = Integer.parseInt(command.split(" ")[1]);

                if (index >= 0 && index <= chest.size() - 1) {
                    String loot = chest.get(index);
                    chest.add(loot);
                    chest.remove(index);
                }
            } else if (command.contains("Steal")) {
                int count = Integer.parseInt(command.split(" ")[1]);

                List<String> stolenItems = new ArrayList<>();

                if (count < chest.size()) {
                    for (int i = count; i > 0; i--) {
                        String stolenItem = chest.get(chest.size() - count);
                        stolenItems.add(stolenItem);
                        chest.remove(stolenItem);
                        count--;
                    }

                    System.out.println(String.join(", ", stolenItems));
                } else {
                    for (int i = 0; i <= chest.size() - 1; i++) {
                        stolenItems.add(chest.get(i));
                        chest.remove(i);
                        i--;
                    }

                    System.out.println(String.join(", ", stolenItems));
                }
            }

            command = scanner.nextLine();
        }

        int lengthChest = 0;

        for (String loot : chest) {
            lengthChest += loot.length();
        }

        if (chest.size() != 0) {
            double averageTreasureGain = lengthChest * 1.0 / chest.size();

            System.out.printf("Average treasure gain: %.2f pirate credits.", averageTreasureGain);
        } else {

            System.out.println("Failed treasure hunt.");
        }
    }
}