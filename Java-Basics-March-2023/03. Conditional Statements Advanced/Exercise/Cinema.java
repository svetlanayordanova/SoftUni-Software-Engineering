import java.util.Scanner;
public class Cinema {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String typeOfProjection = scanner.nextLine();
        int r = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        double totalIncome = 0;
        double totalSeats = r * c;

        switch (typeOfProjection) {
            case "Premiere":
                totalIncome = totalSeats * 12.00;
                break;
            case "Normal":
                totalIncome = totalSeats * 7.50;
                break;
            case "Discount":
                totalIncome = totalSeats * 5.00;
                break;
        }
        System.out.printf("%.2f leva", totalIncome);
    }
}
