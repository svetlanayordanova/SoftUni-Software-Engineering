package final_exam_preparation;

import java.util.Scanner;

public class SecretChat_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        String command = scanner.nextLine();

        while (!command.equals("Reveal")) {
            String[] commandParts = command.split(":\\|:");
            String commandName = commandParts[0];

            switch (commandName) {
                case "InsertSpace":
                    int index = Integer.parseInt(commandParts[1]);

                    String firstPart = message.substring(0, index);
                    String secondPart = message.substring(index);

                    message = firstPart.concat(" ").concat(secondPart);

                    System.out.println(message);
                    break;
                case "Reverse":
                    String substringPart = commandParts[1];

                    StringBuilder reversedSubstring = new StringBuilder();

                    if (message.contains(substringPart)) {
                        message = message.replaceFirst(substringPart, "");

                        for (int i = substringPart.length() - 1; i >= 0; i--) {
                            char ch = substringPart.charAt(i);

                            reversedSubstring.append(ch);
                        }

                        message = message.concat(reversedSubstring.toString());

                        System.out.println(message);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String substring = commandParts[1];
                    String replacement = commandParts[2];

                    message = message.replace(substring, replacement);

                    System.out.println(message);
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.printf("You have a new text message: %s", message);
    }
}