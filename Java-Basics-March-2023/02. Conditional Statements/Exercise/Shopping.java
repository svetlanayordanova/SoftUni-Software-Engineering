import java.util.Scanner;
public class Shopping {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int N = Integer.parseInt(scanner.nextLine());
        int M = Integer.parseInt(scanner.nextLine());
        int P = Integer.parseInt(scanner.nextLine());

        double pricePerN = 250;
        double pricePerM = N * pricePerN * 0.35;
        double pricePerP = N * pricePerN * 0.10;

        double sum = (N * pricePerN) + (M * pricePerM) + (P * pricePerP);

        if (N>M) {
            sum = sum - (sum * 0.15);
        }

        if (budget >= sum) {
            System.out.printf("You have %.2f leva left!", budget - sum);
        } else {
            System.out.printf("Not enough money! You need %.2f leva more!", sum - budget);
        }
    }
}
