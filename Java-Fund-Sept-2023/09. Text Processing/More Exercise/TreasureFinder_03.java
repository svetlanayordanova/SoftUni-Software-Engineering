package text_processing_more_exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TreasureFinder_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String key = scanner.nextLine();
        String input = scanner.nextLine();

        key = key.replaceAll(" ", "");

        while (!input.equals("find")) {
            String keys = "";
            StringBuilder message = new StringBuilder();

            int lengthToRepeat = input.length() / key.length();
            keys = key.repeat(lengthToRepeat);
            int diff = input.length() - keys.length();

            if (diff > 0) {
                for (int i = 0; i <= diff - 1; i++) {
                    keys += keys.charAt(i);
                }
            }

            for (int i = 0; i <= input.length() - 1; i++) {
                char symbol = input.charAt(i);
                symbol -= keys.charAt(i) - '0';
                message.append(symbol);
            }

            String typeRegex = "&(?<type>[A-Za-z]+)&";
            Pattern typePattern = Pattern.compile(typeRegex);
            Matcher typeMatcher = typePattern.matcher(message);

            String coordinatesRegex = "<(?<coordinates>\\w+)>";
            Pattern coordinatesPattern = Pattern.compile(coordinatesRegex);
            Matcher coordinatesMatcher = coordinatesPattern.matcher(message);

            if (typeMatcher.find() && coordinatesMatcher.find()) {
                String type = typeMatcher.group("type");
                String coordinates = coordinatesMatcher.group("coordinates");

                System.out.printf("Found %s at %s%n", type, coordinates);
            }

            input = scanner.nextLine();
        }
    }
}