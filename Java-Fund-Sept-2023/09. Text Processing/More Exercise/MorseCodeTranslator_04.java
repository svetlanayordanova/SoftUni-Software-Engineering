package text_processing_more_exercise;

import java.util.Scanner;

public class MorseCodeTranslator_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\| ");

        String[] english = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
                "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        StringBuilder message = new StringBuilder();

        for (int i = 0; i < input.length; i++) {
            String[] currentElement = input[i].split(" ");
            for (int j = 0; j < currentElement.length; j++) {
                String letter = currentElement[j];
                for (int k = 0; k < morse.length; k++) {
                    if (letter.equals(morse[k])) {
                        message.append(english[k]);
                        break;
                    }
                }
            }

            message.append(" ");
        }

        System.out.println(message);
    }
}