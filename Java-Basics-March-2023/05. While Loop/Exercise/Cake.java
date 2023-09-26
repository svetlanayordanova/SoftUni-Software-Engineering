import java.util.Scanner;
public class Cake {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());

        int totalCakePieces = width * length;

        String input = scanner.nextLine();

        while (!input.equals("STOP")) {
            int currentCakePieces = Integer.parseInt(input);
            totalCakePieces -= currentCakePieces;

            if (totalCakePieces <= 0) {
                System.out.printf("No more cake left! You need %s pieces more.", Math.abs(totalCakePieces));
                return;
            }

            input = scanner.nextLine();
        }

        System.out.printf("%s pieces are left.", totalCakePieces);

    }
}
