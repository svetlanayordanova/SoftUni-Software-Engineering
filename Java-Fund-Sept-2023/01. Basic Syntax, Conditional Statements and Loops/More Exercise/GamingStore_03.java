package basics_recap_more_exercise;

import java.util.Scanner;
public class GamingStore_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double currentBalance = Double.parseDouble(scanner.nextLine());
        String command = scanner.nextLine();

        double spentMoney = 0;

        while (!command.equals("Game Time")) {
            double gamePrice = 0;

            switch (command) {
                case "OutFall 4":
                    gamePrice = 39.99;
                    if (currentBalance >= gamePrice) {
                        currentBalance -= gamePrice;
                        spentMoney += gamePrice;
                        System.out.println("Bought OutFall 4");
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "CS: OG":
                    gamePrice = 15.99;
                    if (currentBalance >= gamePrice) {
                        currentBalance -= gamePrice;
                        spentMoney += gamePrice;
                        System.out.println("Bought CS: OG");
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "Zplinter Zell":
                    gamePrice = 19.99;
                    if (currentBalance >= gamePrice) {
                        currentBalance -= gamePrice;
                        spentMoney += gamePrice;
                        System.out.println("Bought Zplinter Zell");
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "Honored 2":
                    gamePrice = 59.99;
                    if (currentBalance >= gamePrice) {
                        currentBalance -= gamePrice;
                        spentMoney += gamePrice;
                        System.out.println("Bought Honored 2");
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "RoverWatch":
                    gamePrice = 29.99;
                    if (currentBalance >= gamePrice) {
                        currentBalance -= gamePrice;
                        spentMoney += gamePrice;
                        System.out.println("Bought RoverWatch");
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "RoverWatch Origins Edition":
                    gamePrice = 39.99;
                    if (currentBalance >= gamePrice) {
                        currentBalance -= gamePrice;
                        spentMoney += gamePrice;
                        System.out.println("Bought RoverWatch Origins Edition");
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                default:
                    System.out.println("Not Found");
                    break;
            }

            if (currentBalance == 0) {
                System.out.println("Out of money!");
                return;
            }

            command = scanner.nextLine();
        }

        System.out.printf("Total spent: $%.2f. Remaining: $%.2f", spentMoney, currentBalance);
    }
}
