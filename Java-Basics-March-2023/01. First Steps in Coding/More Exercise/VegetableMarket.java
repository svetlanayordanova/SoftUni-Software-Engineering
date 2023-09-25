import java.util.Scanner;

public class VegetableMarket {

    public static void main (String [] args) {

        Scanner scanner = new Scanner(System.in);

        double N = Double.parseDouble(scanner.nextLine ());
        double M = Double.parseDouble(scanner.nextLine ());
        int KgVegetables = Integer.parseInt(scanner.nextLine ());
        int KgFruits = Integer.parseInt(scanner.nextLine ());

        double income = ((N * KgVegetables) + (M * KgFruits)) / 1.94;

        System.out.printf("%.2f", income);

    }
}
