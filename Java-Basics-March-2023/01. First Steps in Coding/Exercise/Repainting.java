import java.util.Scanner;

public class Repainting {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //1.Четем от конзолата
        int nylon = Integer.parseInt(scanner.nextLine());
        int paint = Integer.parseInt(scanner.nextLine());
        int thinner = Integer.parseInt(scanner.nextLine());
        int workerHours = Integer.parseInt(scanner.nextLine());

        //2.Изчисления
        double nylonPrice = (nylon + 2) * 1.50;
        double paintPrice = (paint + (paint * 0.10)) * 14.50;
        double thinnerPrice = thinner * 5.00;
        double materialPrice = nylonPrice + paintPrice + thinnerPrice + 0.40;
        double workerPrice = (materialPrice * 0.30) * workerHours;
        double sum = materialPrice + workerPrice;

        //3.Принтираме на конзолата
        System.out.println(sum);

    }
}
