package text_processing_exercise;

import java.util.Scanner;

public class LettersChangeNumbers_08 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] codes = input.split("\\s+");

        double sum = 0;

        for (String code : codes) {
            double modifiedNumber = getModifiedNumber(code);
            sum += modifiedNumber;
        }

        System.out.printf("%.2f", sum);
    }

    public static double getModifiedNumber(String code) {
        char letterBefore = code.charAt(0);
        char letterAfter = code.charAt(code.length() - 1);
        double number = Double.parseDouble(code.replace(letterBefore, ' ')
                .replace(letterAfter, ' ')
                .trim());

        if (Character.isUpperCase(letterBefore)) {
            int positionUpperLetter = (int) letterBefore - 64;
            number /= positionUpperLetter;
        } else {
            int positionLowerLetter = (int) letterBefore - 96;
            number *= positionLowerLetter;
        }

        if (Character.isUpperCase(letterAfter)) {
            int positionUpperLetter = (int) letterAfter - 64;
            number -= positionUpperLetter;
        } else {
            int positionLowerLetter = (int) letterAfter - 96;
            number += positionLowerLetter;
        }

        return number;
    }
}