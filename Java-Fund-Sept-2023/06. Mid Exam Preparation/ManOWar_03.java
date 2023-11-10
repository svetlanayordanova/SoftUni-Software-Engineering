package mid_exam_preparation;

import java.util.Arrays;
import java.util.Scanner;
public class ManOWar_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] pirateShip = Arrays.stream(scanner.nextLine().split(">"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] warship = Arrays.stream(scanner.nextLine().split(">"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int maxHealthCapacity = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equals("Retire")) {
            if (command.contains("Fire")) {
                int index = Integer.parseInt(command.split(" ")[1]);
                int damage = Integer.parseInt(command.split(" ")[2]);

                if (index >= 0 && index <= warship.length - 1) {
                    warship[index] -= damage;

                    if (warship[index] <= 0) {
                        System.out.println("You won! The enemy ship has sunken.");
                        return;
                    }
                }
            } else if (command.contains("Defend")) {
                int startIndex = Integer.parseInt(command.split(" ")[1]);
                int endIndex = Integer.parseInt(command.split(" ")[2]);
                int damage = Integer.parseInt(command.split(" ")[3]);

                if ((startIndex >= 0 && startIndex <= pirateShip.length - 1) && (endIndex >= 0 && endIndex <= pirateShip.length - 1)) {
                    for (int i = startIndex; i <= endIndex; i++) {
                        pirateShip[i] -= damage;

                        if (pirateShip[i] <= 0) {
                            System.out.println("You lost! The pirate ship has sunken.");
                            return;
                        }
                    }
                }
            } else if (command.contains("Repair")) {
                int index = Integer.parseInt(command.split(" ")[1]);
                int health = Integer.parseInt(command.split(" ")[2]);

                if (index >= 0 && index <= pirateShip.length - 1) {
                    pirateShip[index] += health;

                    if (pirateShip[index] > maxHealthCapacity) {
                        pirateShip[index] = maxHealthCapacity;
                    }
                }
            } else if (command.contains("Status")) {
                int count = 0;

                for (int section : pirateShip) {
                    if (section < (maxHealthCapacity * 0.2)) {
                        count++;
                    }
                }

                System.out.printf("%d sections need repair.%n", count);
            }

            command = scanner.nextLine();
        }

        int sumPirateShip = 0;
        int sumWarship = 0;

        for (int section : pirateShip) {
            sumPirateShip += section;
        }

        for (int section : warship) {
            sumWarship += section;
        }

        System.out.printf("Pirate ship status: %d%n", sumPirateShip);
        System.out.printf("Warship status: %d", sumWarship);
    }
}