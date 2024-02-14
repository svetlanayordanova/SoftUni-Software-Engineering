package sets_and_maps_exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming_11 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> materials = new TreeMap<>();
        Map<String, Integer> junks = new TreeMap<>();

        materials.put("shards", 0);
        materials.put("fragments", 0);
        materials.put("motes", 0);

        String winner = " ";

        while ((" ").equals(winner)) {
            String[] tokens = scanner.nextLine().toLowerCase().split("\\s+");

            for (int i = 0; i < tokens.length; i++) {
                if (i % 2 != 0) {
                    if (("shards").equals(tokens[i]) || ("fragments").equals(tokens[i]) || ("motes").equals(tokens[i])) {
                        if (!materials.containsKey(tokens[i])) {
                            materials.put(tokens[i], Integer.parseInt(tokens[i - 1]));
                        } else {
                            materials.put(tokens[i], materials.get(tokens[i]) + Integer.parseInt(tokens[i - 1]));
                        }

                        winner = determinesWinner(materials, winner, tokens[i]);

                        if (!(" ").equals(winner)) {
                            recalculatesWinnerMaterial(materials, tokens[i]);
                            break;
                        }
                    } else {
                        if (!junks.containsKey(tokens[i])) {
                            junks.put(tokens[i], Integer.parseInt(tokens[i - 1]));
                        } else {
                            junks.put(tokens[i], junks.get(tokens[i]) + Integer.parseInt(tokens[i - 1]));
                        }
                    }
                }
            }
        }

        System.out.println(winner + " obtained!");

        materials.entrySet()
                .stream()
                .sorted((q1, q2) -> q2.getValue().compareTo(q1.getValue()))
                .forEach(entry -> {
                    String material = entry.getKey();
                    int quantityMaterial = entry.getValue();
                    System.out.printf("%s: %d%n", material, quantityMaterial);
                });

        junks.entrySet()
                .forEach(entry1 -> {
                    String junk = entry1.getKey();
                    int quantityJunk = entry1.getValue();
                    System.out.printf("%s: %d%n", junk, quantityJunk);
                });
    }

    public static String determinesWinner(Map<String, Integer> materials, String winner, String material) {
        if (materials.get(material) >= 250) {
            switch (material) {
                case "shards":
                    winner = "Shadowmourne";
                    break;
                case "fragments":
                    winner = "Valanyr";
                    break;
                case "motes":
                    winner = "Dragonwrath";
                    break;
                default:
                    break;
            }
        }

        return winner;
    }

    public static void recalculatesWinnerMaterial(Map<String, Integer> materials, String material) {
        int newValue = materials.get(material) - 250;
        materials.put(material, newValue);
    }
}