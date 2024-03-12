package working_with_abstraction.HotelReservation_04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        double pricePerDay = Double.parseDouble(input[0]);
        int numberOfDays = Integer.parseInt(input[1]);
        String season = input[2].toUpperCase();
        String discount = input[3];

        boolean containsUpperLetter = false;
        int index = 0;

        for (int i = 3; i < discount.length(); i++) {
            if (Character.isUpperCase(discount.charAt(i))) {
                containsUpperLetter = true;
                index = i;
            }
        }

        if (containsUpperLetter) {
            String firstPart = discount.substring(0, index).toUpperCase();
            String secondPart = discount.substring(index).toUpperCase();
            discount = firstPart + "_" + secondPart;
        } else {
            discount = discount.toUpperCase();
        }

        double price = PriceCalculator.calculatePrice(pricePerDay, numberOfDays, Season.valueOf(season), Discount.valueOf(discount));
        System.out.printf("%.2f%n", price);
    }
}