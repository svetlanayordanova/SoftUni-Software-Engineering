package sets_and_maps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set<String> parkingLot = new LinkedHashSet<>();

        while (!"END".equals(input)) {
            String[] tokens = input.split(", ");
            String direction = tokens[0];
            String carNumber = tokens[1];

            if ("IN".equals(direction)) {
                parkingLot.add(carNumber);
            } else if ("OUT".equals(direction)) {
                parkingLot.remove(carNumber);
            }

            input = scanner.nextLine();
        }

        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        }

        for (String carNumber : parkingLot) {
            System.out.println(carNumber);
        }
    }
}