import java.util.Scanner;
public class FlowerShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int M = Integer.parseInt(scanner.nextLine());
        int Z = Integer.parseInt(scanner.nextLine());
        int R = Integer.parseInt(scanner.nextLine());
        int C = Integer.parseInt(scanner.nextLine());
        double present = Double.parseDouble(scanner.nextLine());

        double allFlowers = (M * 3.25) + (Z * 4.0) + (R * 3.50) + (C * 8.0);
        allFlowers = allFlowers - (allFlowers * 0.05);

        if (present <= allFlowers) {
            System.out.printf("She is left with %.0f leva.", Math.floor(allFlowers - present));
        } else {
            System.out.printf("She will have to borrow %.0f leva.", Math.ceil(present - allFlowers));
        }
    }
}
