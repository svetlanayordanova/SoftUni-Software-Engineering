package regular_expressions_exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] demonNames = scanner.nextLine().split("\\s*,\\s*");

        for (String demonName : demonNames) {
            int health = getDemonsHealth(demonName);
            double damage = getDemonsDamage(demonName);

            for (char symbol : demonName.toCharArray()) {
                if (symbol == '*') {
                    damage *= 2;
                } else if (symbol == '/') {
                    damage /= 2;
                }
            }

            System.out.printf("%s - %d health, %.2f damage%n", demonName, health, damage);
        }
    }

    public static int getDemonsHealth(String demonName) {
        int health = 0;

        Pattern pattern = Pattern.compile("[^0-9+\\-*/.]");
        Matcher matcher = pattern.matcher(demonName);

        while (matcher.find()) {
            health += matcher.group().charAt(0);
        }

        return health;
    }

    public static double getDemonsDamage(String demonName) {
        double damage = 0;

        Pattern pattern = Pattern.compile("-?\\d+\\.?\\d*");
        Matcher matcher = pattern.matcher(demonName);

        while (matcher.find()) {
            damage += Double.parseDouble(matcher.group());
        }

        return damage;
    }
}