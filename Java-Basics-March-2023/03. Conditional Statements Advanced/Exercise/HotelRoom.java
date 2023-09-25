import java.util.Scanner;
public class HotelRoom {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int nights = Integer.parseInt(scanner.nextLine());

        double priceForStudio = 0;
        double priceForApartment = 0;

        if (month.equals("May") || month.equals("October")) {
            priceForStudio = nights * 50.0;
            priceForApartment = nights * 65.0;

            if (nights > 14) {
                priceForStudio = priceForStudio - (priceForStudio * 0.30);
            } else if (nights > 7) {
                priceForStudio = priceForStudio - (priceForStudio * 0.05);
            }

        } else if (month.equals("June") || month.equals("September")) {
            priceForStudio = nights * 75.20;
            priceForApartment = nights * 68.70;

            if (nights > 14) {
                priceForStudio = priceForStudio - (priceForStudio * 0.20);
            }

        } else if (month.equals("July") || month.equals("August")) {
            priceForStudio = nights * 76.0;
            priceForApartment = nights * 77.0;
        }

        if (nights > 14) {
            priceForApartment = priceForApartment - (priceForApartment * 0.10);
        }

        System.out.printf("Apartment: %.2f lv.%n", priceForApartment);
        System.out.printf("Studio: %.2f lv.", priceForStudio);
    }
}
