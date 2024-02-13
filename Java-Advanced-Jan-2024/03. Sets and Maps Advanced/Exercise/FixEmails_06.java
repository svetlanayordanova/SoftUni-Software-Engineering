package sets_and_maps_exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails_06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        Map<String, String> emailsList = new LinkedHashMap<>();

        while (!"stop".equals(name)) {
            String email = scanner.nextLine();

            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                emailsList.put(name, email);
            }

            name = scanner.nextLine();
        }

        emailsList.entrySet().forEach(entry -> {
            String personName = entry.getKey();
            String email = entry.getValue();

            System.out.printf("%s -> %s%n", personName, email);
        });
    }
}