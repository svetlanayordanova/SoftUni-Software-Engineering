package mid_exam_preparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> groceries = Arrays.stream(scanner.nextLine().split("!"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Go Shopping!")) {
            if (command.contains("Urgent")) {
                String item = command.split(" ")[1];

                if (!groceries.contains(item)) {
                    groceries.add(0, item);
                }
            } else if (command.contains("Unnecessary")) {
                String item = command.split(" ")[1];

                groceries.remove(item);
            } else if (command.contains("Correct")) {
                String oldItem = command.split(" ")[1];
                String newItem = command.split(" ")[2];

                for (int i = 0; i <= groceries.size() - 1; i++) {
                    if (groceries.get(i).equals(oldItem)) {
                        groceries.set(i, newItem);
                    }
                }
            } else if (command.contains("Rearrange")) {
                String item = command.split(" ")[1];

                groceries.add(item);
                groceries.remove(item);
            }

                command = scanner.nextLine();
        }

        System.out.println(String.join(", ", groceries));
    }
}