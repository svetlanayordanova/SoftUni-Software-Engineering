package methods_exercise;

import java.util.Scanner;
public class NxNMatrix_07 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        printNxNMatrix(n);
    }

    public static void printNxNMatrix(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                System.out.print(n + " ");
            }

            System.out.println();
        }
    }
}
