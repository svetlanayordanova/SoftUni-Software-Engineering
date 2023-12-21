package text_processing;

import java.util.Arrays;
import java.util.Scanner;

public class TextFilter_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");

        String text = scanner.nextLine();

        for (String word : bannedWords) {
            String replacement = genReplacement(word);
            text = text.replace(word, replacement);
        }

        System.out.println(text);
    }

    private static String genReplacement(String word) {
        char[] replacementCharArr = new char[word.length()];
        Arrays.fill(replacementCharArr, '*');
        return new String(replacementCharArr);
    }
}