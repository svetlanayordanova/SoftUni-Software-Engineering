package exam_preparation;

import java.util.*;
import java.util.stream.Collectors;

public class Blacksmith_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Queue<Integer> steel = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(steel::offer);

        Stack<Integer> carbon = new Stack<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(carbon::push);

        Map<String, Integer> swords = new TreeMap<>();

        int countGladius = 0;
        int countShamshir = 0;
        int countKatana = 0;
        int countSabre = 0;

        while (!steel.isEmpty() && !carbon.isEmpty()) {
            int firstSteel = steel.poll();
            int lastCarbon = carbon.pop();

            int sum = firstSteel + lastCarbon;

            if (sum == 70) {
                countGladius++;
                swords.put("Gladius", countGladius);
            } else if (sum == 80) {
                countShamshir++;
                swords.put("Shamshir", countShamshir);
            } else if (sum == 90) {
                countKatana++;
                swords.put("Katana", countKatana);
            } else if (sum == 110) {
                countSabre++;
                swords.put("Sabre", countSabre);
            } else {
                carbon.push(lastCarbon + 5);
            }
        }

        int sumSwords = swords.values().stream().mapToInt(Integer::intValue).sum();
        if (sumSwords != 0) {
            System.out.printf("You have forged %d swords.%n", sumSwords);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if (steel.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            System.out.println("Steel left: " + steel.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (carbon.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            //reverse Stack!!!
            List<String> collect = carbon.stream().map(String::valueOf).collect(Collectors.toList());
            Collections.reverse(collect);
            System.out.println("Carbon left: " + String.join(", ", collect));
        }

        swords.entrySet().forEach(entry -> {
            String swordType = entry.getKey();
            int amount = entry.getValue();

            System.out.printf("%s: %d%n", swordType, amount);
        });
    }
}