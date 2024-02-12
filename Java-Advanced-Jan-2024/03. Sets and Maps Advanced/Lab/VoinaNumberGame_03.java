package sets_and_maps;

import java.util.*;
import java.util.stream.Collectors;

public class VoinaNumberGame_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayerCards = getPlayerNumbers(scanner);
        Set<Integer> secondPlayerCards = getPlayerNumbers(scanner);

        for (int i = 0; i < 50; i++) {
            int firstPlayerNumber = firstPlayerCards.iterator().next();
            firstPlayerCards.remove(firstPlayerNumber);

            int secondPlayerNumber = secondPlayerCards.iterator().next();
            secondPlayerCards.remove(secondPlayerNumber);

            if (firstPlayerNumber > secondPlayerNumber) {
                firstPlayerCards.add(firstPlayerNumber);
                firstPlayerCards.add(secondPlayerNumber);
            } else if (secondPlayerNumber > firstPlayerNumber) {
                secondPlayerCards.add(firstPlayerNumber);
                secondPlayerCards.add(secondPlayerNumber);
            } else {
                firstPlayerCards.add(firstPlayerNumber);
                secondPlayerCards.add(secondPlayerNumber);
            }

            if (firstPlayerCards.isEmpty() || secondPlayerCards.isEmpty()) {
                break;
            }
        }

        if (firstPlayerCards.size() > secondPlayerCards.size()) {
            System.out.println("First player win!");
        } else if (secondPlayerCards.size() > firstPlayerCards.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }

    public static LinkedHashSet<Integer> getPlayerNumbers(Scanner scanner) {

        return Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}