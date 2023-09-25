import java.util.Scanner;

public class SuppliesForSchool {

    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);

        //1.Четем от конзолата
        int pencilPackages = Integer.parseInt(scanner.nextLine());
        int markerPackages = Integer.parseInt(scanner.nextLine());
        int cleanerLiters = Integer.parseInt(scanner.nextLine());
        int percentDiscount = Integer.parseInt(scanner.nextLine());

        //2.Изчисления
        double materialPrice = (pencilPackages * 5.80 + markerPackages * 7.20 + cleanerLiters * 1.20);
        double discount = materialPrice * (percentDiscount / 100.0);

        //3.Принтиране на конзолата
        System.out.println(materialPrice - discount);

    }
}

