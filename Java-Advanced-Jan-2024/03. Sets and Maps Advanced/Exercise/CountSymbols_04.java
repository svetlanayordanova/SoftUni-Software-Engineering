package sets_and_maps_exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Character, Integer> characters = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            characters.putIfAbsent(currentChar, 0);
            int newCount = characters.get(currentChar);
            characters.put(currentChar, newCount + 1);
        }

        characters.entrySet().forEach(entry -> {
            char currentChar = entry.getKey();
            int count = entry.getValue();

            System.out.printf("%c: %d time/s%n", currentChar, count);
        });
    }
}