import java.util.Scanner;

public class BasketballEquipment {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //1.Четем от конзолата
        int annualFee = Integer.parseInt(scanner.nextLine());

        //2.Изчисления
        double sneakersPrice = annualFee - (annualFee * 0.40);
        double suitPrice = sneakersPrice - (sneakersPrice * 0.20);
        double ballPrice = suitPrice / 4;
        double accessoriesPrice = ballPrice / 5;

        double sum = annualFee + sneakersPrice + suitPrice + ballPrice + accessoriesPrice;


        System.out.println(sum);

    }
}
