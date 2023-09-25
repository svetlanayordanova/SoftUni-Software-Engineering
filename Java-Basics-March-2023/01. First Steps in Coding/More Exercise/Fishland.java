import java.util.Scanner;

public class Fishland {

    public static void main (String [] args) {

        Scanner scanner = new Scanner(System.in);

        double priceMackerel = Double.parseDouble(scanner.nextLine());
        double priceSprinkle = Double.parseDouble(scanner.nextLine());
        double kgBonito = Double.parseDouble(scanner.nextLine());
        double kgSafrid = Double.parseDouble(scanner.nextLine());
        double kgMussels = Double.parseDouble(scanner.nextLine());

        double priceBonito = priceMackerel + (priceMackerel * 0.60);
        double priceSafrid = priceSprinkle + (priceSprinkle * 0.80);
        double priceMussels = 7.50;

        double sum = (kgBonito * priceBonito) + (kgSafrid * priceSafrid) + (kgMussels * 7.50);

        System.out.printf("%.2f", sum);

    }
}
