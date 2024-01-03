package final_exam_preparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("(:{2}|\\*{2})[A-Z][a-z]{2,}\\1");
        Matcher matcher = pattern.matcher(text);

        List<String> emojis = new ArrayList<>();

        int countValidEmojis = 0;
        int sumMultiplyText = 1;

        for (int i = 0; i <= text.length() - 1; i++) {
            char currentCh = text.charAt(i);

            if (Character.isDigit(currentCh)) {
                sumMultiplyText *= Integer.parseInt(currentCh + "");
            }
        }

        System.out.printf("Cool threshold: %d%n", sumMultiplyText);

        while (matcher.find()) {
            countValidEmojis++;

            String emoji = matcher.group();
            int sumEmoji = 0;

            for (int i = 0; i <= emoji.length() - 1; i++) {
                char currCh = emoji.charAt(i);

                if (Character.isLetter(currCh)) {
                    sumEmoji += currCh;
                }
            }

            if (sumEmoji > sumMultiplyText) {
                emojis.add(emoji);
            }
        }

        System.out.printf("%d emojis found in the text. The cool ones are:%n", countValidEmojis);

        emojis.forEach(System.out::println);
    }
}