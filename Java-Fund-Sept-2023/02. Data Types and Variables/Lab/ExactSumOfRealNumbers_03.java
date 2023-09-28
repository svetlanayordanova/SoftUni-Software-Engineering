package data_types_and_variables;

import java.math.BigDecimal;
import java.util.Scanner;
public class ExactSumOfRealNumbers_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        BigDecimal result = new BigDecimal("0");

        for (int i = 1; i <= n; i++) {
            BigDecimal number = new BigDecimal(scanner.nextLine());
            result = result.add(number);
        }
        System.out.println(result);
    }
}
