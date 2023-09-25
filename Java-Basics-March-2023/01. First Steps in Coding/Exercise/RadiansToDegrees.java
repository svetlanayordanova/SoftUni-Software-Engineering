import java.util.Scanner;
public class RadiansToDegrees {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //1.Четем от конзолата
        double angleInRadians = Double.parseDouble(scanner.nextLine());

        //2.Изчисления
        double angleInDegrees = angleInRadians * 180 / Math.PI;

        //3.Принтираме на конзолата
        System.out.println(angleInDegrees);

    }
}
