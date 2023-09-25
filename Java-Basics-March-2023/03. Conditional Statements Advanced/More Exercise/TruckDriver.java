import java.util.Scanner;
public class TruckDriver {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        double kmPerMonth = Double.parseDouble(scanner.nextLine());

        double salaryPerSeason = 0;
        double salaryPerOneKm = 0;

        if (kmPerMonth <= 5000) {
            if (season.equals("Spring") || season.equals("Autumn")) {
                salaryPerOneKm = 0.75;
            } else if (season.equals("Summer")) {
                salaryPerOneKm = 0.90;
            } else if (season.equals("Winter")) {
                salaryPerOneKm = 1.05;
            }
        } else if (kmPerMonth <= 10000) {
            if (season.equals("Spring") || season.equals("Autumn")) {
                salaryPerOneKm = 0.95;
            } else if (season.equals("Summer")) {
                salaryPerOneKm = 1.10;
            } else if (season.equals("Winter")) {
                salaryPerOneKm = 1.25;
            }
        } else if (kmPerMonth <= 20000) {
            salaryPerOneKm = 1.45;
        }

        salaryPerSeason = (kmPerMonth * salaryPerOneKm) * 4.0;
        salaryPerSeason = salaryPerSeason - (salaryPerSeason * 0.10);

        System.out.printf("%.2f", salaryPerSeason);
    }
}
