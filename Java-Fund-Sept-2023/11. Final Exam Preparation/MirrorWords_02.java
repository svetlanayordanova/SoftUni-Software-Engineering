package final_exam_preparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("([@#])(?<word>[A-Za-z]{3,})\\1\\1(?<mirror>[A-Za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(text);

        List<String> mirrorPairs = new ArrayList<>();

        int wordPairsCount = 0;

        while (matcher.find()) {
            wordPairsCount++;

            String firstWord = matcher.group("word");
            String secondWord = new StringBuilder(matcher.group("mirror")).reverse().toString();

            if (firstWord.equals(secondWord)) {
                mirrorPairs.add(firstWord + " <=> " + matcher.group("mirror"));
            }
        }

        if (wordPairsCount == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", wordPairsCount);
        }

        if (mirrorPairs.size() == 0) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.print(String.join(", ", mirrorPairs));
        }
    }
}