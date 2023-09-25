import java.util.Scanner;
public class
FishTank {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //1.Четем от конзолата
        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());

        //2.Изчисления
        double volumeInCm = length * width * height;
        double volumeInLiters = volumeInCm / 1000;

        volumeInLiters = volumeInLiters - (volumeInLiters * percent / 100);

        //3.Принтираме на конзолата
        System.out.println(volumeInLiters);

    }
}
