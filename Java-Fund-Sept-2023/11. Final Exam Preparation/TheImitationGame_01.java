package final_exam_preparation;

import java.util.Scanner;

public class TheImitationGame_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        String command = scanner.nextLine();

        while (!command.equals("Decode")) {
            String[] commandParts = command.split("\\|");
            String commandName = commandParts[0];

            switch (commandName) {
                case "Move":
                    int numLetters = Integer.parseInt(commandParts[1]);

                    String firstPart = message.substring(0, numLetters);
                    String secondPart = message.substring(numLetters);
                    message = secondPart.concat(firstPart);
                    break;
                case "Insert":
                    int index = Integer.parseInt(commandParts[1]);
                    String value = commandParts[2];

                    String partFirst = message.substring(0, index);
                    String partSecond = message.substring(index);
                    message = partFirst.concat(value).concat(partSecond);
                    break;
                case "ChangeAll":
                    String substring = commandParts[1];
                    String replacement = commandParts[2];

                    message = message.replace(substring, replacement);
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.printf("The decrypted message is: %s", message);
    }
}