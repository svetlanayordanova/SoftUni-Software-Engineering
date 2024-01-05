package final_exam_preparation;

import java.util.*;

public class Pirates_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, Integer> townPopulation = new LinkedHashMap<>();
        Map<String, Integer> townGold = new LinkedHashMap<>();

        while (!command.equals("Sail")) {
            String town = command.split("\\|\\|")[0];
            int population = Integer.parseInt(command.split("\\|\\|")[1]);
            int gold = Integer.parseInt(command.split("\\|\\|")[2]);

            if (!townPopulation.containsKey(town)) {
                townPopulation.put(town, population);
            } else {
                int currentPopulation = townPopulation.get(town);
                townPopulation.put(town, currentPopulation + population);
            }

            if (!townGold.containsKey(town)) {
                townGold.put(town, gold);
            } else {
                int currentGold = townGold.get(town);
                townGold.put(town, currentGold + gold);
            }

            command = scanner.nextLine();
        }

        String event = scanner.nextLine();

        while (!event.equals("End")) {
            String eventName = event.split("=>")[0];
            String town = event.split("=>")[1];

            int currentPopulation = townPopulation.get(town);
            int currentGold = townGold.get(town);

            switch (eventName) {
                case "Plunder":
                    int people = Integer.parseInt(event.split("=>")[2]);
                    int gold = Integer.parseInt(event.split("=>")[3]);

                    townPopulation.put(town, currentPopulation - people);
                    townGold.put(town, currentGold - gold);

                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);

                    if (townPopulation.get(town) <= 0 || townGold.get(town) <= 0) {
                        townPopulation.remove(town);
                        townGold.remove(town);
                        System.out.printf("%s has been wiped off the map!%n", town);
                    }
                    break;
                case "Prosper":
                    int treasure = Integer.parseInt(event.split("=>")[2]);

                    if (treasure <= 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        townGold.put(town, currentGold + treasure);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", treasure, town, currentGold + treasure);
                    }
                    break;
            }

            event = scanner.nextLine();
        }

        if (!townPopulation.isEmpty()) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", townPopulation.size());

            townPopulation.entrySet()
                    .forEach(entry -> {
                        String town = entry.getKey();
                        int people = entry.getValue();
                        int gold = townGold.get(town);

                        System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", town, people, gold);
                    });
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}