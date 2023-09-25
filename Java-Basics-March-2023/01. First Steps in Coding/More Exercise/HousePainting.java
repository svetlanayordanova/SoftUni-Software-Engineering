import java.util.Scanner;

public class HousePainting {

    public static void main (String [] args) {

        Scanner scanner = new Scanner(System.in);

        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());

        double area1 = (2.0 * x * x) - (1.20 * 2.0);
        double area2 = (2.0 * x * y) - (2.0 * 1.5 * 1.5);
        double area3 = 2.0 * x * y;
        double area4 = 2.0 * (x * h / 2.0);

        double sum1 = (area1 + area2) / 3.40;
        double sum2 = (area3 + area4) / 4.30;

        System.out.printf("%.2f%n", sum1);
        System.out.printf("%.2f", sum2);

    }
}
