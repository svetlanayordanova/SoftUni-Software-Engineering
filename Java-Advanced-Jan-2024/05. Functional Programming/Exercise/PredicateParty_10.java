package functional_programming_exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty_10 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Predicate<String> predicate;

        String line = scanner.nextLine();

        while (!"Party!".equals(line)) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            String criteria = tokens[1];
            String parameter = tokens[2];

            switch (criteria) {
                case "StartsWith":
                    predicate = s -> s.startsWith(parameter);
                    break;
                case "EndsWith":
                    predicate = s -> s.endsWith(parameter);
                    break;
                default:
                    predicate = s -> s.length() == Integer.parseInt(parameter);
                    break;
            }

            if ("Remove".equals(command)) {
                guests.removeIf(predicate);
            } else {
                List<String> guestsToAdd = guests.stream()
                        .filter(predicate)
                        .collect(Collectors.toList());
                guests.addAll(guestsToAdd);
            }

            line = scanner.nextLine();
        }

        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            String result = guests.stream()
                    .sorted()
                    .collect(Collectors.joining(", "));

            System.out.println(result + " are going to the party!");
        }
    }
}