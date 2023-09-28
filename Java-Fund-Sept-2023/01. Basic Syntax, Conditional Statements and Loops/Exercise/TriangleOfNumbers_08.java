package basics_recap_exercise;

import java.util.Scanner;
public class TriangleOfNumbers_08 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int row = 1; row <= n; row++) { //брой на редовете
            for (int number = 1; number <= row; number++) { //колко пъти отпечатвам номера на реда
                System.out.print(row + " ");
            }
            System.out.println();
        }
    }
}
