package mid_exam_preparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> journal = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Craft!")) {
            if (command.contains("Collect")) {
                String item = command.split(" ")[2];

                if (!journal.contains(item)) {
                    journal.add(item);
                }
            } else if (command.contains("Drop")) {
                String item = command.split(" ")[2];
                journal.remove(item);
            } else if (command.contains("Combine")) {
                String twoItems = command.split(" ")[3];
                String oldItem = twoItems.split(":")[0];
                String newItem = twoItems.split(":")[1];

                for (int i = 0; i <= journal.size() - 1; i++) {
                    if (journal.get(i).equals(oldItem)) {
                        journal.add(i + 1, newItem);
                    }
                }
            } else if (command.contains("Renew")) {
                String item = command.split(" ")[2];

                if (journal.contains(item)) {
                    journal.add(item);
                    journal.remove(item);
                }
            }

            command = scanner.nextLine();
        }

        System.out.println(String.join(", ", journal));
    }
}
