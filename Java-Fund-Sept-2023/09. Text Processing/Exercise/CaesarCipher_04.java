package text_processing_exercise;

import java.util.Scanner;

public class CaesarCipher_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        StringBuilder encryptText = new StringBuilder();

        for (char symbol : text.toCharArray()) {
            char encryptSymbol = (char) (symbol + 3);
            encryptText.append(encryptSymbol);
        }

        System.out.println(encryptText);
    }
}