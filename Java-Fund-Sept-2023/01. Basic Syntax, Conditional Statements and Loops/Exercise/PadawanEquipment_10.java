package basics_recap_exercise;

import java.util.Scanner;
public class PadawanEquipment_10 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());
        double priceSaber = Double.parseDouble(scanner.nextLine());
        double priceRobe = Double.parseDouble(scanner.nextLine());
        double priceBelt = Double.parseDouble(scanner.nextLine());

        double sumSabers = Math.ceil(studentsCount + 0.10 * studentsCount) * priceSaber;
        double sumRobes = studentsCount * priceRobe;
        double sumBelts = (studentsCount - studentsCount / 6) * priceBelt;
        double totalSum = sumSabers + sumRobes + sumBelts;

        if (budget >= totalSum) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalSum);
        } else {
            double needMoney = totalSum - budget;
            System.out.printf("George Lucas will need %.2flv more.", needMoney);
        }
    }
}
