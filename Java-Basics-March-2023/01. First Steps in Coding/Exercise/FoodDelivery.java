import java.util.Scanner;

public class FoodDelivery {

    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);

        //1.Четем от конзолата
        int amountOfChickenMenu = Integer.parseInt(scanner.nextLine ());
        int amountOfFishMenu = Integer.parseInt(scanner.nextLine());
        int amountOfVegetarianMenu = Integer.parseInt(scanner.nextLine());

        //2.Изчисления
        double chickenMenuPrice = amountOfChickenMenu * 10.35;
        double fishMenuPrice = amountOfFishMenu * 12.40;
        double vegetarianMenuPrice = amountOfVegetarianMenu * 8.15;
        double allMenusPrice = (chickenMenuPrice + fishMenuPrice + vegetarianMenuPrice);
        double dessertPrice = allMenusPrice * 0.20;
        double deliveryPrice = 2.50;

        double orderPrice = allMenusPrice + dessertPrice + deliveryPrice;

        //3.Принтираме на конзолата
        System.out.println(orderPrice);

    }
}


