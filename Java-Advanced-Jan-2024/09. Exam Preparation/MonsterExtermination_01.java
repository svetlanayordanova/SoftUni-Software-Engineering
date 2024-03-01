package exam_preparation;

import java.util.*;
import java.util.stream.Collectors;

public class MonsterExtermination_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Queue<Integer> monsters = Arrays.stream(scanner.nextLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        Stack<Integer> strikes = new Stack<>();
        Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .forEach(strikes::push);

        int killedMonsters = 0;

        while (!monsters.isEmpty() && !strikes.isEmpty()) {
            int armour = monsters.peek();
            int strike = strikes.peek();

            if (strike >= armour) {
                killedMonsters++;
                strike -= armour;

                if (strike == 0) {
                    strikes.pop();
                    monsters.poll();
                } else {
                    monsters.poll();
                    if (strikes.size() == 1) {
                        strikes.pop();
                        strikes.push(strike);
                    } else {
                        strikes.pop();
                        int previousStrike = strikes.pop();
                        strikes.push(previousStrike + strike);
                    }
                }
            } else {
                armour -= strike;
                strikes.pop();
                monsters.poll();
                monsters.offer(armour);
            }
        }

        if (monsters.isEmpty()) {
            System.out.println("All monsters have been killed!");
        }

        if (strikes.isEmpty()) {
            System.out.println("The soldier has been defeated.");
        }

        System.out.printf("Total monsters killed: %d%n", killedMonsters);
    }
}