package text_processing_more_exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractPersonInformation_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();

            String nameRegex = "@(?<name>[A-za-z]+)\\|";
            Pattern namePattern = Pattern.compile(nameRegex);
            Matcher nameMatcher = namePattern.matcher(input);

            String ageRegex = "#(?<age>\\d{1,2})\\*";
            Pattern agePattern = Pattern.compile(ageRegex);
            Matcher ageMatcher = agePattern.matcher(input);

            if (nameMatcher.find() && ageMatcher.find()) {
                String name = nameMatcher.group("name");
                int age = Integer.parseInt(ageMatcher.group("age"));

                System.out.printf("%s is %d years old.%n", name, age);
            }
        }
    }
}