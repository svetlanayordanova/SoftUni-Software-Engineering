package sets_and_maps_exercise;

import java.util.*;

public class PopulationCounter_09 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Long>> populationByCity = new LinkedHashMap<>();
        Map<String, Long> totalPopulationByCountry = new LinkedHashMap<>();


        while (!"report".equals(input)) {
            String[] tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            populationByCity.putIfAbsent(country, new LinkedHashMap<>());
            populationByCity.get(country).put(city, population);

            if (!totalPopulationByCountry.containsKey(country)) {
                totalPopulationByCountry.put(country, population);
            } else {
                totalPopulationByCountry.put(country, totalPopulationByCountry.get(country) + population);
            }

            input = scanner.nextLine();
        }

        populationByCity.entrySet()
                .stream()
                .sorted((c1, c2) -> totalPopulationByCountry.get(c2.getKey()).compareTo(totalPopulationByCountry.get(c1.getKey())))
                .forEach(entry -> {
                    String country = entry.getKey();
                    Map<String, Long> citiesPopulation = entry.getValue();
                    System.out.printf("%s (total population: %d)%n", country, totalPopulationByCountry.get(country));

                    citiesPopulation.entrySet()
                            .stream()
                            .sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue()))
                            .forEach(entry1 -> {
                                String city = entry1.getKey();
                                long cityPopulation = entry1.getValue();

                                System.out.printf("=>%s: %d%n", city, cityPopulation);
                            });
                });
    }
}