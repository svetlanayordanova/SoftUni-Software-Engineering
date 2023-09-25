import java.util.Scanner;
public class Journey {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String destination = "";
        String place = "";
        double spentMoney = 0;

        if (budget <= 100) {
            destination = "Bulgaria";
            if (season.equals("summer")) {
                spentMoney = budget * 0.30;
                place = "Camp";
            } else if (season.equals("winter")) {
                spentMoney = budget * 0.70;
                place = "Hotel";
            }
        } else if (budget <= 1000) {
            destination = "Balkans";
            if (season.equals("summer")) {
                spentMoney = budget * 0.40;
                place = "Camp";
            } else if (season.equals("winter")) {
                spentMoney = budget * 0.80;
                place = "Hotel";
            }
        } else {
                destination = "Europe";
                spentMoney = budget * 0.90;
                place = "Hotel";
        }
        System.out.printf("Somewhere in %s%n", destination);
        System.out.printf("%s - %.2f", place, spentMoney);
    }
}
