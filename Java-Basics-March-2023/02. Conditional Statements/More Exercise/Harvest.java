import java.util.Scanner;
public class Harvest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int X = Integer.parseInt(scanner.nextLine());
        double Y = Double.parseDouble(scanner.nextLine());
        int Z = Integer.parseInt(scanner.nextLine());
        int numberWorkers = Integer.parseInt(scanner.nextLine());

        double grapePerWine = X * Y * 0.40;
        double grapePerLiterWine = 2.5;
        double wine = grapePerWine / grapePerLiterWine;

        if (wine < Z) {
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", Math.floor(Z - wine));
        } else {
            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n", Math.floor(wine));
            System.out.printf("%.0f liters left -> %.0f liters per person.", Math.ceil(wine - Z), Math.ceil((wine - Z) / numberWorkers));
        }
    }
}
