import java.util.Scanner;

public class CelsiusToFahrenheit {

    public static void main (String [] args) {

        Scanner scanner = new Scanner(System.in);

        double degreeCelsius = Double.parseDouble(scanner.nextLine ());
        double degreeFahrenheit = degreeCelsius * 9 / 5 + 32;

        System.out.printf("%.2f", degreeFahrenheit);

    }
}
