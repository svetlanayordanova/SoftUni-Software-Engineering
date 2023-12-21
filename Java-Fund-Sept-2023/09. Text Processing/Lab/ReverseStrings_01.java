package text_processing;

import java.util.Scanner;

public class ReverseStrings_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String word = scanner.nextLine();

            if (word.equals("end")) {
                break;
            }

            String reversedWord = reverseWord(word);

            System.out.printf("%s = %s%n", word, reversedWord);
        }
    }

    public static String reverseWord(String word) {
        char[] reversedResult = new char[word.length()];
        int reversedResultIdx = 0;

        for (int i = word.length() - 1; i >= 0; i--) {
            char currentChar = word.charAt(i);
            reversedResult[reversedResultIdx] = currentChar;
            reversedResultIdx += 1;
        }

        return new String(reversedResult);
    }
}