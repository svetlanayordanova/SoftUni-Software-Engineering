package final_exam_preparation;

import java.util.*;

public class PlantDiscovery_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int countPlants = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> plantsRarity = new LinkedHashMap<>();
        Map<String, List<Double>> plantsRating = new LinkedHashMap<>();

        for (int plant = 1; plant <= countPlants; plant++) {
            String input = scanner.nextLine();
            String plantName = input.split("<->")[0];
            int rarity = Integer.parseInt(input.split("<->")[1]);

            plantsRarity.put(plantName, rarity);
            plantsRating.putIfAbsent(plantName, new ArrayList<>());
        }

        String command = scanner.nextLine();

        while (!command.equals("Exhibition")) {
            String plantName = command.split(" ")[1];

            if (!plantsRarity.containsKey(plantName)) {
                System.out.println("error");
                command = scanner.nextLine();
                continue;
            }

            if (command.contains("Rate")) {
                double rating = Double.parseDouble(command.split(" ")[3]);
                plantsRating.get(plantName).add(rating);
            } else if (command.contains("Update")) {
                int newRarity = Integer.parseInt(command.split(" ")[3]);
                plantsRarity.put(plantName, newRarity);
            } else if (command.contains("Reset")) {
                plantsRating.get(plantName).clear();
            }

            command = scanner.nextLine();
        }

        System.out.println("Plants for the exhibition:");
        plantsRarity.entrySet().forEach(entry -> {
            String plantName = entry.getKey();
            int rarity = entry.getValue();
            double averageRating = plantsRating.get(plantName)
                    .stream().mapToDouble(a -> a).average().orElse(0.0);

            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", plantName, rarity, averageRating);
        });
    }
}