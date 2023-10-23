package lists_exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame_06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> firstDeck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondDeck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        boolean isGameOver = firstDeck.size() == 0 || secondDeck.size() == 0;
        boolean isWinnerFirstPlayer = false;

        while (!isGameOver) {
            int firstPlayerCard = firstDeck.get(0);
            int secondPlayerCard = secondDeck.get(0);

            if (firstPlayerCard > secondPlayerCard) {
                firstDeck.add(firstPlayerCard);
                firstDeck.remove(0);
                firstDeck.add(secondPlayerCard);
                secondDeck.remove(0);
            } else if (firstPlayerCard < secondPlayerCard) {
                secondDeck.add(secondPlayerCard);
                secondDeck.remove(0);
                secondDeck.add(firstPlayerCard);
                firstDeck.remove(0);
            } else {
                firstDeck.remove(0);
                secondDeck.remove(0);
            }

            if (firstDeck.size() == 0) {
                isGameOver = true;
            } else if (secondDeck.size() == 0) {
                isGameOver = true;
                isWinnerFirstPlayer = true;
            }
        }

        int sum = 0;

        if (isWinnerFirstPlayer) {
            for (int number : firstDeck) {
                sum += number;
            }

            System.out.printf("First player wins! Sum: %d", sum);
        } else {
            for (int number : secondDeck) {
                sum += number;
            }

            System.out.printf("Second player wins! Sum: %d", sum);
        }
    }
}