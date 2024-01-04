package final_exam_preparation;

import java.util.Scanner;

public class PasswordReset_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        String command = scanner.nextLine();

        while (!command.equals("Done")) {
            String[] commandParts = command.split(" ");
            String commandName = commandParts[0];

            switch (commandName) {
                case "TakeOdd":
                    String newPass = "";

                    for (int index = 0; index <= password.length() - 1; index++) {
                        if (index % 2 != 0) {
                            char ch = password.charAt(index);
                            newPass += ch;
                        }
                    }

                    password = newPass;

                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(commandParts[1]);
                    int length = Integer.parseInt(commandParts[2]);

                    String extractPart = password.substring(index, index + length);
                    password = password.replaceFirst(extractPart, "");

                    System.out.println(password);
                    break;
                case "Substitute":
                    String substring = commandParts[1];
                    String substitute = commandParts[2];

                    if (password.contains(substring)) {
                        password = password.replace(substring, substitute);
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.printf("Your password is: %s", password);
    }
}