import java.util.Scanner;
public class PipesInPool {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int V = Integer.parseInt(scanner.nextLine());
        int P1 = Integer.parseInt(scanner.nextLine());
        int P2 = Integer.parseInt(scanner.nextLine());
        double H = Double.parseDouble(scanner.nextLine());

        double waterFromP1 = P1 * H;
        double waterFromP2 = P2 * H;
        double waterInSwimmingPool = waterFromP1 + waterFromP2;
        double waterFromP1InPercent = (waterFromP1 * 100) / waterInSwimmingPool;
        double waterFromP2InPercent = (waterFromP2 * 100) / waterInSwimmingPool;
        double waterInSwimmingPoolInPercent = (waterInSwimmingPool * 100) / V;
        char percent = '%';

        if (waterInSwimmingPool <= V) {
            System.out.printf("The pool is %.2f%c full. Pipe 1: %.2f%c. Pipe 2: %.2f%c.", waterInSwimmingPoolInPercent, percent , waterFromP1InPercent, percent, waterFromP2InPercent, percent);
        } else {
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.", H, waterInSwimmingPool - V);
        }
    }
}
