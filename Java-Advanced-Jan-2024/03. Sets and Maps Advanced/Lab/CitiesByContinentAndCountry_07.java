package sets_and_maps;

import java.util.*;

public class CitiesByContinentAndCountry_07 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<String>>> cities = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            cities.putIfAbsent(continent, new LinkedHashMap<>());
            cities.get(continent).putIfAbsent(country, new ArrayList<>());
            cities.get(continent).get(country).add(city);
        }

        cities.entrySet().forEach(entry -> {
            String continent = entry.getKey();
            Map<String, List<String>> citiesByCountry = entry.getValue();

            System.out.printf("%s:%n", continent);

            citiesByCountry.entrySet().forEach(entry1 -> {
                String country = entry1.getKey();
                List<String> towns = entry1.getValue();

                System.out.printf(" %s -> %s%n", country, String.join(", ", towns));
            });
        });
    }
}