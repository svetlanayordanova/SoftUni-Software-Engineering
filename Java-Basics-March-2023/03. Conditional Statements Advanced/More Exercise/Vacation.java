import java.util.Scanner;
public class Vacation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        double price = 0;
        String location = "";
        String place = "";

        if (budget <= 1000) {
            place = "Camp";
            if (season.equals("Summer")) {
                location = "Alaska";
                price = budget * 0.65;
            } else if (season.equals("Winter")) {
                location = "Morocco";
                price = budget * 0.45;
            }
        } else if (budget <= 3000) {
            place = "Hut";
            if (season.equals("Summer")) {
                location = "Alaska";
                price = budget * 0.80;
            } else if (season.equals("Winter")) {
                location = "Morocco";
                price = budget * 0.60;
            }
        } else {
            place = "Hotel";
            price = budget * 0.90;
            if (season.equals("Summer")) {
                location = "Alaska";
            } else if (season.equals("Winter")) {
                location = "Morocco";
            }
        }
        System.out.printf("%s - %s - %.2f", location, place, price);
    }
}
