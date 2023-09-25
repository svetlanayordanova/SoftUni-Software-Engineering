import java.util.Scanner;
public class TradeCommissions {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String town = scanner.nextLine();
        double s = Double.parseDouble(scanner.nextLine());

        boolean isValidData = true;
        double commission = 0;

        if (town.equals("Sofia")) {
            if (s >= 0 && s <= 500) {
                commission = s * 0.05;
            } else if (s > 500 && s <= 1000) {
                commission = s * 0.07;
            } else if (s > 1000 && s <= 10000) {
                commission = s * 0.08;
            } else if (s > 10000) {
                commission = s * 0.12;
            } else {
                isValidData = false;
            }

        } else if (town.equals("Varna")) {
            if (s >= 0 && s <= 500) {
                commission = s * 0.045;
            } else if (s > 500 && s <= 1000) {
                commission = s * 0.075;
            } else if (s > 1000 && s <= 10000) {
                commission = s * 0.1;
            } else if (s > 10000) {
                commission = s * 0.13;
            } else {
                isValidData = false;
            }

        } else if (town.equals("Plovdiv")) {
            if (s >= 0 && s <= 500) {
                commission = s * 0.055;
            } else if (s > 500 && s <= 1000) {
                commission = s * 0.08;
            } else if (s > 1000 && s <= 10000) {
                commission = s * 0.12;
            } else if (s > 10000) {
                commission = s * 0.145;
            } else {
                isValidData = false;
            }

        } else {
            isValidData = false;
        }

        if (isValidData) {
            System.out.printf("%.2f", commission);
        } else {
            System.out.println("error");
        }
    }
}
