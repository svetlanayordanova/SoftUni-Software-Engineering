package final_exam_preparation;

import java.util.*;

public class HeroesOfCodeAndLogicVII_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> heroHitPoints = new LinkedHashMap<>();
        Map<String, Integer> heroManaPoints = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String heroName = input[0];
            int hitPoints = Integer.parseInt(input[1]);
            int manaPoints = Integer.parseInt(input[2]);

            heroHitPoints.putIfAbsent(heroName, hitPoints);
            heroManaPoints.putIfAbsent(heroName, manaPoints);
        }

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String commandName = command.split(" - ")[0];
            String heroName = command.split(" - ")[1];

            int currentHitPoints = heroHitPoints.get(heroName);
            int currentManaPoints = heroManaPoints.get(heroName);

            switch (commandName) {
                case "CastSpell":
                    int manaPointsNeeded = Integer.parseInt(command.split(" - ")[2]);
                    String spellName = command.split(" - ")[3];

                    if (manaPointsNeeded <= currentManaPoints) {
                        heroManaPoints.put(heroName, currentManaPoints - manaPointsNeeded);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, currentManaPoints - manaPointsNeeded);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(command.split(" - ")[2]);
                    String attacker = command.split(" - ")[3];

                    heroHitPoints.put(heroName, currentHitPoints - damage);

                    if (heroHitPoints.get(heroName) > 0) {
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, currentHitPoints - damage);
                    } else {
                        heroHitPoints.remove(heroName);
                        heroManaPoints.remove(heroName);
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                    }
                    break;
                case "Recharge":
                    int manaPointsAmount = Integer.parseInt(command.split(" - ")[2]);
                    int rechargedAmount = 0;

                    if (currentManaPoints + manaPointsAmount > 200) {
                       heroManaPoints.put(heroName, 200);
                        rechargedAmount = 200 - currentManaPoints;
                    } else {
                        heroManaPoints.put(heroName, currentManaPoints + manaPointsAmount);
                        rechargedAmount = manaPointsAmount;
                    }

                    System.out.printf("%s recharged for %d MP!%n", heroName, rechargedAmount);
                    break;
                case "Heal":
                    int hitPointsAmount = Integer.parseInt(command.split(" - ")[2]);
                    int healedAmount = 0;

                    if (currentHitPoints + hitPointsAmount > 100) {
                        heroHitPoints.put(heroName, 100);
                        healedAmount = 100 - currentHitPoints;
                    } else {
                        heroHitPoints.put(heroName, currentHitPoints + hitPointsAmount);
                        healedAmount = hitPointsAmount;
                    }

                    System.out.printf("%s healed for %d HP!%n", heroName, healedAmount);
                    break;
            }

            command = scanner.nextLine();
        }

        heroHitPoints.entrySet()
                .forEach(entry -> {
                    String heroName = entry.getKey();
                    int hitPoints = entry.getValue();
                    int manaPoints = heroManaPoints.get(heroName);
                    System.out.println(heroName);
                    System.out.printf(" HP: %d%n", hitPoints);
                    System.out.printf(" MP: %d%n", manaPoints);
                });
    }
}