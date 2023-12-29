package regular_expressions_exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        StringBuilder decryptedMessage = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            String message = scanner.nextLine();

            int countLetters = getCountLetters(message);

            for (char symbol : message.toCharArray()) {
                symbol -= countLetters;
                decryptedMessage.append(symbol);
            }
        }

        String regex = "@(?<planetName>[A-Za-z]+)[^@\\-!:>]*:(?<planetPopulation>[0-9]+)[^@\\-!:>]*!(?<attackType>[AD])![^@\\-!:>]*->(?<soldierCount>[0-9]+)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(decryptedMessage.toString());

        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        while (matcher.find()) {
            String planetName = matcher.group("planetName");
            String attackType = matcher.group("attackType");

            if (attackType.equals("A")) {
                attackedPlanets.add(planetName);
            } else if (attackType.equals("D")) {
                destroyedPlanets.add(planetName);
            }
        }

        Collections.sort(attackedPlanets);
        Collections.sort(destroyedPlanets);

        System.out.println("Attacked planets: " + attackedPlanets.size());
        attackedPlanets.forEach(planet ->
                System.out.println("-> " + planet));
        System.out.println("Destroyed planets: " + destroyedPlanets.size());
        destroyedPlanets.forEach(planet ->
                System.out.println("-> " + planet));
    }

    public static int getCountLetters(String message) {
        int countLetters = 0;

        Pattern pattern = Pattern.compile("[STARstar]");
        Matcher matcher = pattern.matcher(message);

        while (matcher.find()) {
            countLetters++;
        }

        return countLetters;
    }
}