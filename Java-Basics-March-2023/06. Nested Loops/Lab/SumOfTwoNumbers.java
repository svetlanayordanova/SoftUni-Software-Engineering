import java.util.Scanner;
public class SumOfTwoNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int magicNum = Integer.parseInt(scanner.nextLine());

        boolean validComb = false;
        int countCombination = 0;

        for (int i = firstNum; i <= secondNum; i++) {
            for (int j = firstNum; j <= secondNum; j++) {
                countCombination++;
                int sum = i + j;

                if (sum == magicNum) {
                    System.out.printf("Combination N:%d (%d + %d = %d)%n", countCombination, i, j, magicNum);
                    validComb = true;
                    break;
                }
            }
            if (validComb) {
                break;
            }
        }
            if (!validComb) {
            System.out.printf("%d combinations - neither equals %d", countCombination, magicNum);
        }
    }
}
