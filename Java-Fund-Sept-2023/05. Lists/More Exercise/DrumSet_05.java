package lists_more_exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet_05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double savings = Double.parseDouble(scanner.nextLine());

        List<Integer> drumSet = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        List<Integer> initialQuality = new ArrayList<>();

        for (int i = 0; i <= drumSet.size() - 1; i++) {
            initialQuality.add(drumSet.get(i));
        }

        while (!command.equals("Hit it again, Gabsy!")) {
            int hitPower = Integer.parseInt(command);

            for (int i = 0; i <= drumSet.size() - 1; i++) {
                int currentQuality = drumSet.get(i) - hitPower;
                drumSet.set(i, currentQuality);

                if (currentQuality <= 0) {
                    double priceDrum = initialQuality.get(i) * 3;

                    if (savings >= priceDrum) {
                        savings -= priceDrum;
                        drumSet.set(i, initialQuality.get(i));
                    } else {
                        drumSet.remove(i);
                        initialQuality.remove(i);
                        i--;
                    }
                }
            }

            command = scanner.nextLine();
        }

        for (int num : drumSet) {
            System.out.print(num + " ");
        }

        System.out.printf("%nGabsy has %.2flv.", savings);
    }
}