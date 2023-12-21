package maps_lambda_and_streamAPI_more_exercise;

import java.util.*;

public class Snowwhite_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> dwarfs = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Once upon a time")) {
            String[] inputParts = input.split(" <:> ");
            String dwarfName = inputParts[0];
            String dwarfHatColor = inputParts[1];
            int dwarfPhysics = Integer.parseInt(inputParts[2]);

            if (!dwarfs.containsKey(dwarfHatColor)) {
                dwarfs.put(dwarfHatColor, new LinkedHashMap<>());
                dwarfs.get(dwarfHatColor).put(dwarfName, dwarfPhysics);
            } else {
                if (!dwarfs.get(dwarfHatColor).containsKey(dwarfName)) {
                    dwarfs.get(dwarfHatColor).put(dwarfName, dwarfPhysics);
                } else {
                    if (dwarfPhysics > dwarfs.get(dwarfHatColor).get(dwarfName)) {
                        dwarfs.get(dwarfHatColor).put(dwarfName, dwarfPhysics);
                    }
                }
            }

            input = scanner.nextLine();
        }

        Map<String, Integer> sortedDwarfs = new LinkedHashMap<>();
        for (Map.Entry<String, Map<String, Integer>> entry : dwarfs.entrySet()) {
            for (Map.Entry<String, Integer> entry1 : entry.getValue().entrySet()) {
                sortedDwarfs.put(entry.getKey() + " " + entry1.getKey() + " " + entry.getValue().size(), entry1.getValue());
            }
        }

        sortedDwarfs
                .entrySet()
                .stream()
                .sorted((entry2, entry1) -> {
                    int sort = Integer.compare(entry1.getValue(), entry2.getValue());
                    if (sort == 0) {
                        String[] sort1 = entry1.getKey().split(" ");
                        String[] sort2 = entry2.getKey().split(" ");
                        sort = sort1[2].compareTo(sort2[2]);
                    }
                    return sort;
                })
                .forEach(entry -> {
                    String[] parts = entry.getKey().split(" ");
                    System.out.printf("(%s) %s <-> %d%n", parts[0], parts[1], entry.getValue());
                });
    }
}