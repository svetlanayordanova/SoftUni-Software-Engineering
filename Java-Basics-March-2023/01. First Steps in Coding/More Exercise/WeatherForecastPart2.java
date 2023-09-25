import java.util.Scanner;

public class WeatherForecastPart2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double degree = Double.parseDouble(scanner.nextLine());

        if (degree < 5.0) {
            System.out.println("unknown");
        } else if (degree <= 11.90) {
            System.out.println("Cold");
        } else if (degree <= 14.90) {
            System.out.println("Cool");
        } else if (degree <= 20.0) {
            System.out.println("Mild");
        } else if (degree <= 25.90) {
            System.out.println("Warm");
        } else if (degree <= 35.0) {
            System.out.println("Hot");
        } else if (degree > 35.0) {
            System.out.println("unknown");

        }
    }
}
