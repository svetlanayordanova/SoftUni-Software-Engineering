import java.util.Scanner;
public class MatchTickets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double allBudget = Double.parseDouble(scanner.nextLine());
        String category = scanner.nextLine();
        int num = Integer.parseInt(scanner.nextLine());

        double budgetPerTransport = 0;
        double budgetPerTickets = 0;

        if (category.equals("VIP")) {
            budgetPerTickets = num * 499.99;
        } else if (category.equals("Normal")) {
            budgetPerTickets = num * 249.99;
        }

        if (num >= 1 && num <= 4) {
            budgetPerTransport = allBudget * 0.75;
        } else if (num <= 9) {
            budgetPerTransport = allBudget * 0.60;
        } else if (num <= 24) {
            budgetPerTransport = allBudget * 0.50;
        } else if (num <= 49) {
            budgetPerTransport = allBudget * 0.40;
        } else {
            budgetPerTransport = allBudget * 0.25;
        }

        double budgetNeeded = budgetPerTransport + budgetPerTickets;

        if (allBudget >= budgetNeeded) {
            System.out.printf("Yes! You have %.2f leva left.", allBudget - budgetNeeded);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", budgetNeeded - allBudget);
        }
    }
}
