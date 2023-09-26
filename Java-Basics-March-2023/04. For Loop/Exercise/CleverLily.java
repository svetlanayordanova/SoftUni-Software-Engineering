import java.util.Scanner;
public class CleverLily {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        double washingMachinePrice = Double.parseDouble(scanner.nextLine());
        int toyPrice = Integer.parseInt(scanner.nextLine());

        int toys = 0;
        double LilyMoney = 0.00;
        double birthdayMoney = 10.0;

        for (int i = 1; i <= age; i++) {
            if (i % 2 == 0) {
                LilyMoney += birthdayMoney;
                birthdayMoney += 10.0;
                LilyMoney -= 1.0;
            } else {
                toys++;
            }
        }
        LilyMoney += toys * toyPrice;

        if (LilyMoney >= washingMachinePrice) {
            System.out.printf("Yes! %.2f", LilyMoney - washingMachinePrice);
        } else {
            System.out.printf("No! %.2f", washingMachinePrice - LilyMoney);
        }
    }
}
