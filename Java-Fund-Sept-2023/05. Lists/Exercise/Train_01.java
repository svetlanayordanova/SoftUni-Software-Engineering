package lists_exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("end")) {
            if (command.contains("Add")) {
                int count = Integer.parseInt(command.split(" ")[1]);

                wagons.add(count);
            } else {
                int passengersCount = Integer.parseInt(command);

                for (int wagon = 0; wagon <= wagons.size() - 1; wagon++) {
                    int passengersPerWagon = wagons.get(wagon);

                    if (passengersPerWagon + passengersCount <= maxCapacity) {
                        wagons.set(wagon, passengersPerWagon + passengersCount);
                        break;
                    }
                }
            }

            command = scanner.nextLine();
        }

        for (int number : wagons) {
            System.out.print(number + " ");
        }
    }
}