package final_exam_preparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String places = scanner.nextLine();

        Pattern pattern = Pattern.compile("([=/])(?<destination>[A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(places);

        List<String> matches = new ArrayList<>();

        int travelPoints = 0;

        while (matcher.find()) {
            String destination = matcher.group("destination");

            matches.add(destination);
            travelPoints += destination.length();
        }

        System.out.println("Destinations: " + String.join(", ", matches));
        System.out.printf("Travel Points: %d", travelPoints);
    }
}