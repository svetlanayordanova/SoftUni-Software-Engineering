package text_processing_exercise;

import java.util.Scanner;

public class StringExplosion_07 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine());
        int strength = 0;

        for (int i = 0; i < input.length(); i++) {
            if (String.valueOf(input.charAt(i)).equals(">")) {
                strength += Integer.parseInt(String.valueOf(input.charAt(i + 1)));
                input.deleteCharAt(i + 1);
                strength--;
            } else if (strength != 0 && Character.isLetter(input.charAt(i))) {
                input.deleteCharAt(i);
                i--;
                strength--;
            }
        }

        System.out.println(input);
    }
}