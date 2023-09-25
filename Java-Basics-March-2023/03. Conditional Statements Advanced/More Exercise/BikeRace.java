import java.util.Scanner;
public class BikeRace {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numJuniors = Integer.parseInt(scanner.nextLine());
        int numSeniors = Integer.parseInt(scanner.nextLine());
        String traceType = scanner.nextLine();

        double sum = 0;

        if (traceType.equals("trail")) {
            sum = (numJuniors * 5.50) + (numSeniors * 7.0);

        } else if (traceType.equals("cross-country")) {
            sum = (numJuniors * 8.0) + (numSeniors * 9.50);

            int numAll = numJuniors + numSeniors;

            if (numAll >= 50) {
                sum = sum - (sum * 0.25);
            }

        } else if (traceType.equals("downhill")) {
            sum = (numJuniors * 12.25) + (numSeniors * 13.75);

        } else if (traceType.equals("road")) {
            sum = (numJuniors * 20.0) + (numSeniors * 21.50);
        }

        sum = sum - (sum * 0.05);
        System.out.printf("%.2f", sum);
    }
}

