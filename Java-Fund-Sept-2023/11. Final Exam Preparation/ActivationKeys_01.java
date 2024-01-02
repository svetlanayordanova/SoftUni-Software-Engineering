package final_exam_preparation;

import java.util.Scanner;

public class ActivationKeys_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String command = scanner.nextLine();

        while (!command.equals("Generate")) {
            String[] commandParts = command.split(">>>");
            String commandName = commandParts[0];

            switch (commandName) {
                case "Contains":
                    String substring = commandParts[1];

                    if (input.contains(substring)) {
                        System.out.printf("%s contains %s%n", input, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String upperOrLowerCase = commandParts[1];
                    int startIndex = Integer.parseInt(commandParts[2]);
                    int endIndex = Integer.parseInt(commandParts[3]);

                    String firstPart = input.substring(0, startIndex);
                    String secondPart = input.substring(endIndex);

                    String extractPart = input.substring(startIndex, endIndex);

                    for (int i = 0; i <= extractPart.length() - 1; i++) {
                        char currentCh = extractPart.charAt(i);

                        if (upperOrLowerCase.equals("Upper")) {
                            if (Character.isLowerCase(currentCh)) {
                                extractPart = extractPart.replace(currentCh, Character.toUpperCase(currentCh));
                            }
                        } else if (upperOrLowerCase.equals("Lower")) {
                            if (Character.isUpperCase(currentCh)) {
                                extractPart = extractPart.replace(currentCh, Character.toLowerCase(currentCh));
                            }
                        }
                    }

                    input = firstPart.concat(extractPart).concat(secondPart);

                    System.out.println(input);
                    break;
                case "Slice":
                    int startIdx = Integer.parseInt(commandParts[1]);
                    int endIdx = Integer.parseInt(commandParts[2]);

                    String substringPart = input.substring(startIdx, endIdx);
                    input = input.replace(substringPart, "");

                    System.out.println(input);
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.printf("Your activation key is: %s", input);
    }
}