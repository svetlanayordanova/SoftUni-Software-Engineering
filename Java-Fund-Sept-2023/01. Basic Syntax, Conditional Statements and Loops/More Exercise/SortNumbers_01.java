package basics_recap_more_exercise;

import java.util.Scanner;
public class SortNumbers_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        if (firstNum >= secondNum && secondNum >= thirdNum) {
            System.out.println(firstNum);
            System.out.println(secondNum);
            System.out.println(thirdNum);
        } else if (firstNum >= thirdNum && thirdNum >= secondNum) {
            System.out.println(firstNum);
            System.out.println(thirdNum);
            System.out.println(secondNum);
        } else if (secondNum >= firstNum && firstNum >= thirdNum) {
            System.out.println(secondNum);
            System.out.println(firstNum);
            System.out.println(thirdNum);
        } else if (secondNum >= thirdNum && thirdNum >= firstNum) {
            System.out.println(secondNum);
            System.out.println(thirdNum);
            System.out.println(firstNum);
        } else if (thirdNum >= firstNum && firstNum >= secondNum) {
            System.out.println(thirdNum);
            System.out.println(firstNum);
            System.out.println(secondNum);
        } else if (thirdNum >= secondNum && secondNum >= firstNum) {
            System.out.println(thirdNum);
            System.out.println(secondNum);
            System.out.println(firstNum);
        }
    }
}
