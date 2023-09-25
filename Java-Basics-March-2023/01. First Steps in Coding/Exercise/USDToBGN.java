import java.util.Scanner;
public class USDToBGN {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //1.Четем от конзолата
        double USD = Double.parseDouble(scanner.nextLine());

        //2.Изчисления
        double BGN = USD * 1.79549;

        //3.Принтираме на конзолата
        System.out.println(BGN);

    }
}
