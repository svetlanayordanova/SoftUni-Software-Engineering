package basics_recap_exercise;

import java.util.Scanner;
public class RageExpenses_11 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int lostGamesCount = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int trashedHeadsetsCount = lostGamesCount / 2;
        int trashedMousesCount = lostGamesCount / 3;
        int trashedKeyboardsCount = lostGamesCount / 6;
        int trashedDisplaysCount = lostGamesCount / 12;

        double headsetExpenses = headsetPrice * trashedHeadsetsCount;
        double mouseExpenses = mousePrice * trashedMousesCount;
        double keyboardExpenses = keyboardPrice * trashedKeyboardsCount;
        double displayExpenses = displayPrice * trashedDisplaysCount;

        double totalExpenses = headsetExpenses + mouseExpenses + keyboardExpenses + displayExpenses;

        System.out.printf("Rage expenses: %.2f lv.", totalExpenses);
    }
}
