package final_exam_preparation;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("([#|])(?<item>[A-Za-z\\s]+)\\1(?<date>\\d{2}/\\d{2}/\\d{2})\\1(?<calories>\\d{1,5})\\1");
        Matcher matcher = pattern.matcher(text);

        int totalCalories = 0;
        StringBuilder foodsOutput = new StringBuilder();

        while (matcher.find()) {
            String item = matcher.group("item");
            String date = matcher.group("date");
            int calories = Integer.parseInt(matcher.group("calories"));

            totalCalories += calories;
            String output = String.format("Item: %s, Best before: %s, Nutrition: %s%n", item, date, calories);
            foodsOutput.append(output);
        }

        int days = totalCalories / 2000;

        System.out.printf("You have food to last you for: %d days!%n", days);
        System.out.println(foodsOutput);
    }
}