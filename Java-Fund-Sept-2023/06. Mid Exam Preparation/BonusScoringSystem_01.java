package mid_exam_preparation;

import java.util.Scanner;
public class BonusScoringSystem_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int studentsNumber = Integer.parseInt(scanner.nextLine());
        int lecturesNumber = Integer.parseInt(scanner.nextLine());
        int bonus = Integer.parseInt(scanner.nextLine());

        double maxBonus = 0;
        int maxAttendance = 0;

        for (int i = 1; i <= studentsNumber; i++) {
            int studentAttendance = Integer.parseInt(scanner.nextLine());

            double totalBonus = studentAttendance * 1.0 / lecturesNumber * (5 + bonus);

            if (totalBonus >= maxBonus) {
                maxBonus = totalBonus;
                maxAttendance = studentAttendance;
            }
        }

        System.out.printf("Max Bonus: %.0f.%n", Math.ceil(maxBonus));
        System.out.printf("The student has attended %d lectures.", maxAttendance);
    }
}