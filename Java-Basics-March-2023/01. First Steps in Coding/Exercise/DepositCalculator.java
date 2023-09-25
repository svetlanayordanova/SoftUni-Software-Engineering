import java.util.Scanner;

public class DepositCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //1.Четем от конзолата
        double depositAmount = Double.parseDouble(scanner.nextLine());
        int depositPeriod = Integer.parseInt(scanner.nextLine());
        double depositPercent = Double.parseDouble(scanner.nextLine()) / 100.0;

        //2.Изчисления
        double sum = depositAmount + depositPeriod * ((depositAmount * depositPercent) / 12);





        System.out.println(sum);

    }
}
