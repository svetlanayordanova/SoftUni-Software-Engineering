package mid_exam_preparation;

import java.util.Scanner;
public class CounterStrike_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int initialEnergy = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        int countWonBattles = 0;
        int leftEnergy = initialEnergy;

        while (!command.equals("End of battle")) {
            int distance = Integer.parseInt(command);

            if (leftEnergy >= distance) {
                countWonBattles++;
                leftEnergy -= distance;

                if (countWonBattles % 3 == 0) {
                    leftEnergy += countWonBattles;
                }
            } else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", countWonBattles, leftEnergy);
                return;
            }

            command = scanner.nextLine();
        }

        System.out.printf("Won battles: %d. Energy left: %d", countWonBattles, leftEnergy);
    }
}
