package mid_exam_preparation;

import java.util.Scanner;
public class BlackFlag_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());

        double gainedPlunder = 0;

        for (int day = 1; day <= days; day++) {
            gainedPlunder += dailyPlunder;

            if (day % 3 == 0) {
                gainedPlunder += dailyPlunder / 2.0;
            }

            if (day % 5 == 0) {
                gainedPlunder -= gainedPlunder * 0.30;
            }
        }

        if (gainedPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", gainedPlunder);
        } else {
            double percentage = (gainedPlunder * 100) / expectedPlunder;
            System.out.printf("Collected only %.2f%% of the plunder.", percentage);
        }
    }
}