package text_processing_exercise;

import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyBigNumber_05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BigInteger firstNumber = new BigInteger(scanner.nextLine());
        byte secondNumber = Byte.parseByte(scanner.nextLine());

        System.out.println(firstNumber.multiply(new BigInteger(secondNumber + "")));
    }
}