package text_processing_exercise;

import java.util.Scanner;

public class ReplaceRepeatingChars_06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length() - 1; i++) {
            char currentCh = input.charAt(i);
            char nextCh = input.charAt(i + 1);

            if (currentCh != nextCh) {
                sb.append(currentCh);
            }
        }

        sb.append(input.charAt(input.length() - 1));
        System.out.println(sb);
    }
}