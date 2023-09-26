import java.util.Scanner;
public class Dishwasher {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int countOfCharging = 0;
        int amountOfDetergentForDishes = 0;

        while (!input.equals("End")) {
            int bottles = Integer.parseInt(input);
            int amountOfDetergent = bottles * 750;

            int dishes = Integer.parseInt(scanner.nextLine());
            countOfCharging++;
            amountOfDetergentForDishes = dishes * 5;
            amountOfDetergent -= amountOfDetergentForDishes;

            if (countOfCharging % 3 == 0) {
                int pots = Integer.parseInt(scanner.nextLine());
                countOfCharging++;
                amountOfDetergentForDishes = pots * 15;
                amountOfDetergent -= amountOfDetergentForDishes;

                input = scanner.nextLine();

                if (amountOfDetergentForDishes <= amountOfDetergent) {
                    System.out.println("Detergent was enough!");
                    System.out.printf("%d dishes and %d pots were washed.%n", dishes, pots);
                    System.out.printf("Leftover detergent %d ml.", amountOfDetergent - amountOfDetergentForDishes);
                } else {
                    System.out.printf("Not enough detergent, %d ml. more necessary", amountOfDetergentForDishes - amountOfDetergent);
                }
            }
        }
    }
}
