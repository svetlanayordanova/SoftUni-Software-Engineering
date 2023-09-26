import java.util.Scanner;
public class Moving {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());

        int capacity = width * length * height;

        String input = scanner.nextLine();

        while (!input.equals("Done")) {
            int numOfCartons = Integer.parseInt(input);
            capacity -= numOfCartons;

            if (capacity <= 0) {
                System.out.printf("No more free space! You need %s Cubic meters more.", Math.abs(capacity));
                return;
            }

            input = scanner.nextLine();
        }

            System.out.printf("%s Cubic meters left.", capacity);

    }
}
