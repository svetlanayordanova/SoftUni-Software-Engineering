package methods_exercise;

import java.util.Scanner;
public class PasswordValidator_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine().toLowerCase();

        boolean isBetween6And10Characters = checkBetween6And10Characters(password);
        boolean consistsOnlyLettersAndDigits = checkConsistsOnlyLettersAndDigits(password);
        boolean consistsAtLeast2Digits = checkConsistsAtLeast2Digits(password);

        if (isBetween6And10Characters && consistsOnlyLettersAndDigits && consistsAtLeast2Digits) {
            System.out.println("Password is valid");
        }
    }

    public static boolean checkBetween6And10Characters(String password) {
        int count = 0;

        for (char symbol : password.toCharArray()) {
            count++;
        }

        if (count >= 6 && count <= 10) {
            return true;
        } else {
            System.out.println("Password must be between 6 and 10 characters");
            return false;
        }
    }

    public static boolean checkConsistsOnlyLettersAndDigits(String password) {
        for (char symbol : password.toCharArray()) {
            boolean isValid = ((symbol >= 'a' && symbol <= 'z') || (symbol >= '0' && symbol <= '9'));
            if (!isValid) {
                System.out.println("Password must consist only of letters and digits");
                return false;
            }
        }

        return true;
    }

    public static boolean checkConsistsAtLeast2Digits(String password) {
        int count = 0;

        for (char symbol : password.toCharArray()) {
            if (symbol >= '0' && symbol <= '9') {
                count++;
            }
        }

        if (count >= 2) {
            return true;
        } else {
            System.out.println("Password must have at least 2 digits");
            return false;
        }
    }
}
