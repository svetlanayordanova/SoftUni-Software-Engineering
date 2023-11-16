package mid_exam_preparation;

import java.util.Scanner;
public class SoftUniReception_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int firstEmployeeEfficiencyPerHour = Integer.parseInt(scanner.nextLine());
        int secondEmployeeEfficiencyPerHour = Integer.parseInt(scanner.nextLine());
        int thirdEmployeeEfficiencyPerHour = Integer.parseInt(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());

        int allEfficiencyPerHour = firstEmployeeEfficiencyPerHour + secondEmployeeEfficiencyPerHour + thirdEmployeeEfficiencyPerHour;
        int hours = 0;

        if (studentsCount > 0) {
            if (studentsCount <= allEfficiencyPerHour) {
                hours = 1;
            } else {
                while (studentsCount > 0) {
                    studentsCount -= allEfficiencyPerHour;
                    hours++;

                    if (hours % 4 == 0) {
                        hours++;
                    }
                }
            }

            System.out.printf("Time needed: %dh.", hours);

        } else if (studentsCount == 0) {
            System.out.println("Time needed: 0h.");
        }
    }
}
