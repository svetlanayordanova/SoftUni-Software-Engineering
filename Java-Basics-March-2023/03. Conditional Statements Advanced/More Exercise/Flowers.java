import java.util.Scanner;
public class Flowers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numChrysanthemums = Integer.parseInt(scanner.nextLine());
        int numRoses = Integer.parseInt(scanner.nextLine());
        int numTulips = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        String isHoliday = scanner.nextLine();

        double priceOfBucket = 0;
        double priceOfChrysanthemums = 0;
        double priceOfRoses = 0;
        double priceOfTulips = 0;
        int numFlowers = numChrysanthemums + numRoses + numTulips;

        if (isHoliday.equals("N")) {
            if (season.equals("Spring") || season.equals("Summer")) {
                priceOfChrysanthemums = numChrysanthemums * 2.0;
                priceOfRoses = numRoses * 4.10;
                priceOfTulips = numTulips * 2.50;

            } else if (season.equals("Autumn") || season.equals("Winter")) {
                priceOfChrysanthemums = numChrysanthemums * 3.75;
                priceOfRoses = numRoses * 4.50;
                priceOfTulips = numTulips * 4.15;
            }

        } else if (isHoliday.equals("Y")) {
            if (season.equals("Spring") || season.equals("Summer")) {
                priceOfChrysanthemums = (numChrysanthemums * 2.0) + ((numChrysanthemums * 2.0) * 0.15);
                priceOfRoses = (numRoses * 4.10) + ((numRoses * 4.10) * 0.15);
                priceOfTulips = (numTulips * 2.50) + ((numTulips * 2.50) * 0.15);

            } else if (season.equals("Autumn") || season.equals("Winter")) {
                priceOfChrysanthemums = (numChrysanthemums * 3.75) + ((numChrysanthemums * 3.75) * 0.15);
                priceOfRoses = (numRoses * 4.50) + ((numRoses * 4.50) * 0.15);
                priceOfTulips = (numTulips * 4.15) + ((numTulips * 4.15) * 0.15);
            }
        }

        priceOfBucket = priceOfChrysanthemums + priceOfRoses + priceOfTulips;

        if (season.equals("Spring") && numTulips > 7) {
                priceOfBucket = priceOfBucket - (priceOfBucket * 0.05);
            } else if (season.equals("Winter") && numRoses >= 10) {
                priceOfBucket = priceOfBucket - (priceOfBucket * 0.10);
            }

            if (numFlowers > 20) {
                priceOfBucket = priceOfBucket - (priceOfBucket * 0.20);
            }

        priceOfBucket = priceOfBucket + 2.0;
        System.out.printf("%.2f", priceOfBucket);
    }
}
