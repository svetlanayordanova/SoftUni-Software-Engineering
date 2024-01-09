package final_exam_preparation;

import java.util.Scanner;

public class WorldTour_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String stops = scanner.nextLine();
        String command = scanner.nextLine();

        while (!command.equals("Travel")) {
            String[] commandParts = command.split(":");

            if (command.contains("Add")) {
                int index = Integer.parseInt(commandParts[1]);
                String str = commandParts[2];

                if (index >= 0 && index < stops.length()) {
                    String firstPart = stops.substring(0, index);
                    String secondPart = stops.substring(index);

                    stops = firstPart.concat(str).concat(secondPart);
                }

                System.out.println(stops);
            } else if (command.contains("Remove")) {
                int startIndex = Integer.parseInt(commandParts[1]);
                int endIndex = Integer.parseInt(commandParts[2]);

                if (startIndex >= 0 && startIndex < stops.length() && endIndex >= 0 && endIndex < stops.length()) {
                    String extractPart = stops.substring(startIndex, endIndex + 1);

                    stops = stops.replace(extractPart, "");
                }

                System.out.println(stops);
            } else if (command.contains("Switch")) {
                String oldString = commandParts[1];
                String newString = commandParts[2];

                if (stops.contains(oldString)) {
                    stops = stops.replace(oldString, newString);
                }

                System.out.println(stops);
            }

            command = scanner.nextLine();
        }

        System.out.printf("Ready for world tour! Planned stops: %s", stops);
    }
}