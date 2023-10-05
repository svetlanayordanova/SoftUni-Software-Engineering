package arrays_exercise;

import java.util.Scanner;
public class Train_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int countWagons = Integer.parseInt(scanner.nextLine());

        int[] allWagons = new int[countWagons];

        int sum = 0;

        for (int i = 0; i <= allWagons.length - 1; i++) {
            int people = Integer.parseInt(scanner.nextLine());
            allWagons[i] = people;
            sum += people;
        }

        for (int i = 0; i <= allWagons.length - 1; i++) {
            System.out.print(allWagons[i] + " ");
        }
        System.out.println();
        System.out.println(sum);
    }
}
