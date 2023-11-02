package mid_exam_preparation;

import java.util.Scanner;
public class ComputerStore_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        double sumWithoutTaxes = 0;
        double taxes = 0;
        double totalSum = 0;

        while (!command.equals("special") && !command.equals("regular")) {
            double price = Double.parseDouble(command);

            if (price < 0) {
                System.out.println("Invalid price!");
            } else {
                sumWithoutTaxes += price;
            }

            command = scanner.nextLine();
        }

        taxes = 0.2 * sumWithoutTaxes;
        totalSum = sumWithoutTaxes + taxes;

        if (command.equals("special")) {
            totalSum = totalSum - 0.1 * totalSum;
        }

        if (totalSum == 0) {
            System.out.println("Invalid order!");
        } else {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", sumWithoutTaxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$%n", totalSum);
        }
    }
}
