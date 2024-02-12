package sets_and_maps;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String guest = scanner.nextLine();
        Set<String> guests = new TreeSet<>();

        while (!"PARTY".equals(guest)) {
            guests.add(guest);

            guest = scanner.nextLine();
        }

        while (!"END".equals(guest)) {
            guests.remove(guest);

            guest = scanner.nextLine();
        }

        System.out.println(guests.size());
        guests.forEach(System.out::println);
    }
}