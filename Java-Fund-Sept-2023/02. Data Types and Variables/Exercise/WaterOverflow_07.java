package data_types_and_variables_exercise;

import java.util.Scanner;
public class WaterOverflow_07 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int capacity = 255;
        int litersInTank = 0;

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            int pouredLiters = Integer.parseInt(scanner.nextLine());

            if (capacity < pouredLiters) {
                System.out.println("Insufficient capacity!");
            } else {
                capacity -= pouredLiters;
                litersInTank += pouredLiters;
            }
        }
        System.out.println(litersInTank);
    }
}
