package exam_preparation;

import java.util.*;
import java.util.stream.Collectors;

public class KAT_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> licensePlates = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        Deque<Integer> cars = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int countRegisteredCars = 0;
        int days = 0;

        while (!licensePlates.isEmpty() && !cars.isEmpty()) {
            int currentCountLicensePlates = licensePlates.removeFirst();
            int currentCountCars = cars.removeLast();

            if (currentCountLicensePlates / 2 >= currentCountCars) {
                int countRemainingPlates = currentCountLicensePlates - currentCountCars * 2;
                if (countRemainingPlates != 0) {
                    licensePlates.addLast(countRemainingPlates);
                }
                countRegisteredCars += currentCountCars;
            } else {
                int countRemainingCars = currentCountCars - currentCountLicensePlates / 2;
                cars.addFirst(countRemainingCars);
                countRegisteredCars += currentCountCars - countRemainingCars;
            }
            days++;
        }

        System.out.printf("%d cars were registered for %d days!%n", countRegisteredCars, days);

        if (!licensePlates.isEmpty()) {
            int totalRemainingPlates = 0;

            for (int licensePlate : licensePlates) {
                totalRemainingPlates += licensePlate;
            }

            System.out.printf("%d license plates remain!%n", totalRemainingPlates);
        } else if (!cars.isEmpty()) {
            int totalRemainingCars = 0;

            for (int car : cars) {
                totalRemainingCars += car;
            }

            System.out.printf("%d cars remain without license plates!%n", totalRemainingCars);
        } else {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
    }
}