package lists_exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int countCommands = Integer.parseInt(scanner.nextLine());

        List<String> guests = new ArrayList<>();

        for (int i = 1; i <= countCommands; i++) {
            String[] command = scanner.nextLine().split(" ");
            String name = command[0];
            String commandPart = command[2];

            if (commandPart.equals("going!")) {
                if (!guests.contains(name)) {
                    guests.add(name);
                } else {
                    System.out.printf("%s is already in the list!%n", name);
                }
            } else if (commandPart.equals("not")) {
                if (guests.contains(name)) {
                    guests.remove(name);
                } else {
                    System.out.printf("%s is not in the list!%n", name);
                }
            }
        }

        for (String name : guests) {
            System.out.println(name);
        }
    }
}