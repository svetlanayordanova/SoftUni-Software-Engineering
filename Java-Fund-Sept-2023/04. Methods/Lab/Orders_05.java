package methods;

import java.util.Scanner;
public class Orders_05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        double singlePrice = 0;

        switch (product) {
            case "coffee":
                singlePrice = 1.50;
                break;
            case "water":
                singlePrice = 1;
                break;
            case "coke":
                singlePrice = 1.40;
                break;
            case "snacks":
                singlePrice = 2;
                break;
        }

        calculateTheTotalPrice(singlePrice, quantity);
    }

    public static void calculateTheTotalPrice(double singlePrice, int quantity) {
        double totalPrice = singlePrice * quantity;
        System.out.printf("%.2f", totalPrice);
    }
}
