package sets_and_maps_exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook_05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, String> phonebook = new HashMap<>();

        while (!"search".equals(input)) {
            String[] tokens = input.split("-");
            String name = tokens[0];
            String phoneNumber = tokens[1];

            phonebook.put(name, phoneNumber);

            input = scanner.nextLine();
        }

        String name = scanner.nextLine();

        while (!"stop".equals(name)) {
            if (phonebook.containsKey(name)) {
                System.out.println(name + " -> " + phonebook.get(name));
            } else {
                System.out.printf("Contact %s does not exist.%n", name);
            }

            name = scanner.nextLine();
        }
    }
}