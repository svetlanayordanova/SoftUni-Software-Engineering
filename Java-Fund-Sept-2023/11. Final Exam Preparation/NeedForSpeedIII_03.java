package final_exam_preparation;

import java.util.*;

public class NeedForSpeedIII_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> carMileage = new LinkedHashMap<>();
        Map<String, Integer> carFuel = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split("\\|");
            String car = input[0];
            int mileage = Integer.parseInt(input[1]);
            int fuel = Integer.parseInt(input[2]);

            carMileage.putIfAbsent(car, mileage);
            carFuel.putIfAbsent(car, fuel);
        }

        String command = scanner.nextLine();

        while (!command.equals("Stop")) {
            String commandName = command.split(" : ")[0];
            String car = command.split(" : ")[1];

            switch (commandName) {
                case "Drive":
                    int distance = Integer.parseInt(command.split(" : ")[2]);
                    int requiredFuel = Integer.parseInt(command.split(" : ")[3]);

                    int currentMileage = carMileage.get(car);
                    int currentFuel = carFuel.get(car);

                    if (currentFuel < requiredFuel) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        carMileage.put(car, currentMileage + distance);
                        carFuel.put(car, currentFuel - requiredFuel);

                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, requiredFuel);

                        if (carMileage.get(car) >= 100_000) {
                            carMileage.remove(car);
                            carFuel.remove(car);
                            System.out.printf("Time to sell the %s!%n", car);
                        }
                    }
                    break;
                case "Refuel":
                    int fuelToRefill = Integer.parseInt(command.split(" : ")[2]);
                    int currentFuelInTank = carFuel.get(car);

                    if (fuelToRefill + currentFuelInTank > 75) {
                        fuelToRefill = 75 - currentFuelInTank;
                    }

                    carFuel.put(car, currentFuelInTank + fuelToRefill);
                    System.out.printf("%s refueled with %d liters%n", car, fuelToRefill);
                    break;
                case "Revert":
                    int revertedKilometers = Integer.parseInt(command.split(" : ")[2]);
                    int currentMileageOfCar = carMileage.get(car);

                    if (currentMileageOfCar - revertedKilometers < 10_000) {
                        carMileage.put(car, 10_000);
                    } else {
                        carMileage.put(car, currentMileageOfCar - revertedKilometers);
                        System.out.printf("%s mileage decreased by %d kilometers%n", car, revertedKilometers);
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        carMileage.entrySet()
                .forEach(entry -> {
                    String car = entry.getKey();
                    int mileage = entry.getValue();
                    int fuel = carFuel.get(car);
                    System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", car, mileage, fuel);
                });
    }
}