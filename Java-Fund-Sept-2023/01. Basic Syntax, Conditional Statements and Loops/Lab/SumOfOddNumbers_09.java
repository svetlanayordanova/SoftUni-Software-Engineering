package basics_recap;

import java.util.Scanner;
public class SumOfOddNumbers_09 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int next = 1;
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            System.out.println(next);
            sum += next;
            next += 2;
        }
        System.out.printf("Sum: %d", sum);
    }
}
