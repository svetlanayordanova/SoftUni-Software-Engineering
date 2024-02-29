package exam_preparation;

import java.util.*;
import java.util.stream.Collectors;

public class ClimbThePeaks_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> peaks = new ArrayDeque<>(Arrays.asList("Vihren", "Kutelo", "Banski Suhodol", "Polezhan", "Kamenitza"));
        HashMap<String, Integer> peaksAndLevels = new LinkedHashMap<>(Map.of("Vihren", 80,
                "Kutelo", 90,
                "Banski Suhodol", 100,
                "Polezhan", 60,
                "Kamenitza", 70));

        List<String> conqueredPeaks = new ArrayList<>();
        ArrayDeque<Integer> foodPortionsStack = Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> staminaQueue = Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        while (!peaksAndLevels.isEmpty() && !foodPortionsStack.isEmpty() && !staminaQueue.isEmpty()) {
            String currentPeakName = peaks.getFirst();
            if (foodPortionsStack.getLast() + staminaQueue.getFirst() >= peaksAndLevels.get(currentPeakName)) {
                conqueredPeaks.add(currentPeakName);
                staminaQueue.removeFirst();
                foodPortionsStack.removeLast();
                peaksAndLevels.remove(currentPeakName);
                peaks.remove(currentPeakName);
            } else {
                staminaQueue.removeFirst();
                foodPortionsStack.removeLast();
            }
        }

        if (peaksAndLevels.isEmpty()) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }

        if (!conqueredPeaks.isEmpty()) {
            System.out.println("Conquered peaks:");
            System.out.println(conqueredPeaks.stream().map(String::valueOf).collect(Collectors.joining(System.lineSeparator())));
        }
    }
}