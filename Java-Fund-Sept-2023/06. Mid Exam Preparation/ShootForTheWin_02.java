package mid_exam_preparation;

import java.util.Arrays;
import java.util.Scanner;
public class ShootForTheWin_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] targets = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine();

        int countShots = 0;

        while (!command.equals("End")) {
            int index = Integer.parseInt(command);

            if (index <= targets.length - 1) {
                int[] temp = targets;
                for (int i = 0; i <= temp.length - 1; i++) {
                    if ((temp[i] != -1) && (index != i)) {
                        if (targets[index] < temp[i]) {
                            temp[i] = temp[i] - targets[index];
                        } else {
                            temp[i] = temp[i] + targets[index];
                        }
                    }
                }

                targets[index] = -1;
                countShots++;
            }

            command = scanner.nextLine();
        }

        System.out.printf("Shot targets: %d -> ", countShots);

        for (int number : targets) {
            System.out.print(number + " ");
        }
    }
}
