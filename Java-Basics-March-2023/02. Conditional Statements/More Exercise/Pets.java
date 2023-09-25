import java.util.Scanner;
public class Pets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int allFood = Integer.parseInt(scanner.nextLine());
        double dogFoodPerDayInKg = Double.parseDouble(scanner.nextLine());
        double catFoodPerDayInKg = Double.parseDouble(scanner.nextLine());
        double turtlePerDayInGr = Double.parseDouble(scanner.nextLine());

        double animalsFood = (dogFoodPerDayInKg + catFoodPerDayInKg + (turtlePerDayInGr / 1000)) * days;

        if (allFood >= animalsFood) {
            System.out.printf("%.0f kilos of food left.", Math.floor(allFood - animalsFood));
        } else {
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(animalsFood - allFood));
        }
    }
}
