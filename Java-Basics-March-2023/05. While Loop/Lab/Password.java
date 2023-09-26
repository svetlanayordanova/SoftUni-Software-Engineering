import java.util.Scanner;
public class Password {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String regPass = scanner.nextLine();

        String pass = scanner.nextLine();

        while (!pass.equals(regPass)) {
            pass = scanner.nextLine();
        }

        System.out.printf("Welcome %s!", username);
    }
}
