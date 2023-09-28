package basics_recap_exercise;

import java.util.Scanner;
public class VendingMachine_07 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double sumCoin = 0;

        while (!input.equals("Start")) {
            double coin = Double.parseDouble(input);

            if (coin == 0.1 || coin == 0.2 || coin == 0.5 || coin == 1 || coin == 2) {
                sumCoin += coin;
            } else {
                System.out.printf("Cannot accept %.2f%n", coin);
            }
            input = scanner.nextLine();
        }

        String product = scanner.nextLine();

        while (!product.equals("End")) {
            switch (product) {
                case "Nuts":
                    if (sumCoin >= 2) {
                        System.out.println("Purchased Nuts");
                        sumCoin -= 2;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Water":
                    if (sumCoin >= 0.70) {
                        System.out.println("Purchased Water");
                        sumCoin -= 0.70;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Crisps":
                    if (sumCoin >= 1.50) {
                        System.out.println("Purchased Crisps");
                        sumCoin -= 1.50;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Soda":
                    if (sumCoin >= 0.80) {
                        System.out.println("Purchased Soda");
                        sumCoin -= 0.80;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Coke":
                    if (sumCoin >= 1) {
                        System.out.println("Purchased Coke");
                        sumCoin -= 1;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }
            product = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", sumCoin);
    }
}
