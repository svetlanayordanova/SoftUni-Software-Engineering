import java.util.Scanner;
public class TransportPrice {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String dayOrNight = scanner.nextLine();

        if (n < 20) {
            if (dayOrNight.equals("day")) {
                double taxiPerDay = 0.70 + (0.79 * n);
                System.out.printf("%.2f", taxiPerDay);
            } else if (dayOrNight.equals("night")) {
                double taxiPerNight = 0.70 + (0.90 * n);
                System.out.printf("%.2f", taxiPerNight);
            }
        } else if (n >= 100) {
            double bus = n * 0.09;
            double train = n * 0.06;
            if (bus < train) {
                System.out.printf("%.2f", bus);
            } else {
                System.out.printf("%.2f", train);
            }
        } else {
            double bus = n * 0.09;
            System.out.printf("%.2f", bus);
        }
    }
}
