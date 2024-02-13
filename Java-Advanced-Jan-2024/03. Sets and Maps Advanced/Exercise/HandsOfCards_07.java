package sets_and_maps_exercise;

import java.util.*;

public class HandsOfCards_07 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Set<String>> playersCards = new LinkedHashMap<>();

        while (!"JOKER".equals(input)) {
            String[] tokens = input.split(": ");
            String personName = tokens[0];
            String[] powersAndTypes = tokens[1].split(", ");

            for (String powerAndType : powersAndTypes) {
                playersCards.putIfAbsent(personName, new LinkedHashSet<>());
                playersCards.get(personName).add(powerAndType);
            }

            input = scanner.nextLine();
        }

        Map<String, Integer> powers = new HashMap<>(Map.of("1", 1, "2", 2, "3", 3, "4", 4, "5", 5, "6", 6, "7", 7, "8", 8, "9", 9, "10", 10));
        powers.put("J", 11);
        powers.put("Q", 12);
        powers.put("K", 13);
        powers.put("A", 14);

        Map<String, Integer> types = Map.of("S", 4, "H", 3, "D", 2, "C", 1);

        for (Map.Entry<String, Set<String>> entry : playersCards.entrySet()) {
            String name = entry.getKey();
            Set<String> powerAndTypes = entry.getValue();
            int totalValuePerPlayer = 0;

            for (String e : powerAndTypes) {
                String power = "";
                String type = "";

                if (e.length() == 2) {
                    power = e.substring(0, 1);
                    type = e.substring(1);
                } else if (e.length() == 3) {
                    power = e.substring(0, 2);
                    type = e.substring(2);
                }

                int currentCardValue = powers.get(power) * types.get(type);
                totalValuePerPlayer += currentCardValue;
            }

            System.out.printf("%s: %d%n", name, totalValuePerPlayer);
        }
    }
}