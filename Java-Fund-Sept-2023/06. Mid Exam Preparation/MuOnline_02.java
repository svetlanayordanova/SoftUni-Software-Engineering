package mid_exam_preparation;

import java.util.Scanner;
public class MuOnline_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] rooms = scanner.nextLine().split("\\|");

        int initialHealth = 100;
        int currentHealth = initialHealth;
        int totalBitcoins = 0;

        for (int i = 0; i <= rooms.length - 1; i++) {
            String room = rooms[i];

            if (room.contains("potion")) {
                int heal = Integer.parseInt(room.split(" ")[1]);

                if ((currentHealth + heal) < 100) {
                    currentHealth += heal;
                } else {
                    heal = initialHealth - currentHealth;
                    currentHealth = initialHealth;
                }

                System.out.printf("You healed for %d hp.%n", heal);
                System.out.printf("Current health: %d hp.%n", currentHealth);

            } else if (room.contains("chest")) {
                int bitcoins = Integer.parseInt(room.split(" ")[1]);
                System.out.printf("You found %d bitcoins.%n", bitcoins);
                totalBitcoins += bitcoins;
            } else {
                String monster = room.split(" ")[0];
                int attack = Integer.parseInt(room.split(" ")[1]);
                currentHealth -= attack;

                if (currentHealth > 0) {
                    System.out.printf("You slayed %s.%n", monster);
                } else {
                    System.out.printf("You died! Killed by %s.%n", monster);
                    System.out.printf("Best room: %d", i + 1);
                    return;
                }
            }
        }

        System.out.println("You've made it!");
        System.out.printf("Bitcoins: %d%n", totalBitcoins);
        System.out.printf("Health: %d", currentHealth);
    }
}