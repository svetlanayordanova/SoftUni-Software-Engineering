package maps_lambda_and_streamAPI_more_exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DragonArmy_05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, int[]>> dragons = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String type = input[0];
            String name = input[1];
            int damage = input[2].equals("null") ? 45 : Integer.parseInt(input[2]);
            int health = input[3].equals("null") ? 250 : Integer.parseInt(input[3]);
            int armor = input[4].equals("null") ? 10 : Integer.parseInt(input[4]);

            Map<String, int[]> nameAndStats = new TreeMap<>();
            int[] stats = new int[3];
            stats[0] = damage;
            stats[1] = health;
            stats[2] = armor;
            nameAndStats.put(name,stats);

            if (!dragons.containsKey(type)) {
                dragons.put(type, nameAndStats);
            } else {
                dragons.get(type).remove(name);
                dragons.get(type).put(name, stats);
            }
        }

        dragons.entrySet().forEach(entry -> {
            double damageAvg = 0;
            double healthAvg = 0;
            double armorAvg = 0;

            for (int[] ints : entry.getValue().values()) {
                damageAvg += ints[0];
                healthAvg += ints[1];
                armorAvg += ints[2];
            }

            damageAvg /= entry.getValue().size();
            healthAvg /= entry.getValue().size();
            armorAvg /= entry.getValue().size();

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", entry.getKey(), damageAvg, healthAvg, armorAvg);
            dragons.get(entry.getKey()).forEach((k, v) -> System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", k, v[0], v[1], v[2]));
            });
    }
}