package sets_and_maps_exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrabskoUnleashed_12 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String data = scanner.nextLine();

        Map<String, Map<String, Integer>> dataByVenue = new LinkedHashMap<>();
        String regex = "(?<singerName>\\w+(\\s\\w+){0,2}) @(?<venue>\\w+(\\s\\w+){0,2}) (?<ticketsPrice>\\d{1,3}) (?<ticketsCount>\\d{1,6})";

        while (!"End".equals(data)) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(data);

            if (matcher.find()) {
                String singerName = matcher.group("singerName");
                String venue = matcher.group("venue");
                int ticketsPrice = Integer.parseInt(matcher.group("ticketsPrice"));
                int ticketsCount = Integer.parseInt(matcher.group("ticketsCount"));

                int totalAmount = ticketsPrice * ticketsCount;

                dataByVenue.putIfAbsent(venue, new LinkedHashMap<>());

                if (!dataByVenue.get(venue).containsKey(singerName)) {
                    dataByVenue.get(venue).put(singerName, totalAmount);
                } else {
                    dataByVenue.get(venue).put(singerName, dataByVenue.get(venue).get(singerName) + totalAmount);
                }
            }

            data = scanner.nextLine();
        }

        dataByVenue.entrySet()
                .forEach(entry -> {
                    String venue = entry.getKey();
                    Map<String, Integer> dataBySingers = entry.getValue();

                    System.out.printf("%s%n", venue);

                    dataBySingers.entrySet()
                            .stream()
                            .sorted((a1, a2) -> a2.getValue().compareTo(a1.getValue()))
                            .forEach(entry1 -> {
                                String singerName = entry1.getKey();
                                int totalAmount = entry1.getValue();

                                System.out.printf("#  %s -> %d%n", singerName, totalAmount);
                            });
                });
    }
}