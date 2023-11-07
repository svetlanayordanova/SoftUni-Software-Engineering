package mid_exam_preparation;

import java.util.Arrays;
import java.util.Scanner;

public class HeartDelivery_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split("@"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine();

        int currentLength = 0;
        int houseCount = 0;

        while (!command.equals("Love!")) {

            int[] temp = array;

            if (command.contains("Jump")) {
                int index = Integer.parseInt(command.split(" ")[1]);

                currentLength += index;

                if (currentLength > temp.length - 1) {
                    currentLength = 0;
                }

                for (int i = 0; i <= temp.length - 1; i++) {
                    if (i == currentLength && temp[i] == 0 && temp[currentLength] == 0) {
                        System.out.printf("Place %d already had Valentine's day.%n", i);
                        break;
                    } else if (i == currentLength) {
                        temp[currentLength] -= 2;

                        if (temp[currentLength] == 0) {
                            System.out.printf("Place %d has Valentine's day.%n", currentLength);
                            houseCount++;
                            break;
                        }
                    }
                }
            }

            command = scanner.nextLine();
        }

        boolean isSuccessful = true;

        for (int number : array) {
            if (number != 0) {
                isSuccessful = false;
                break;
            }
        }

        System.out.printf("Cupid's last position was %d.%n", currentLength);

        if (isSuccessful) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.", array.length - houseCount);
        }
    }
}