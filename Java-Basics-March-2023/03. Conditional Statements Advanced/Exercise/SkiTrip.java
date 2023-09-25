import java.util.Scanner;
public class SkiTrip {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        String room = scanner.nextLine();
        String positiveOrNegative = scanner.nextLine();

        double price = 0;

        if (room.equals("room for one person")) {
            price = (days - 1) * 18.0;
        } else if (room.equals("apartment")) {
            price = (days - 1) * 25.0;
            if (days < 10) {
                price = price - (price * 0.30);
            } else if (days <= 15) {
                price = price - (price * 0.35);
            } else {
                price = price - (price * 0.50);
            }
        } else if (room.equals("president apartment")) {
            price = (days - 1) * 35.0;
            if (days < 10) {
                price = price - (price * 0.10);
            } else if (days <= 15) {
                price = price - (price * 0.15);
            } else {
                price = price - (price * 0.20);
            }
        }

            if (positiveOrNegative.equals("positive")) {
                price = price + (price * 0.25);
            } else if (positiveOrNegative.equals("negative")) {
                price = price - (price * 0.10);
            }
        System.out.printf("%.2f", price);
    }
}
