import java.util.Scanner;
public class WorkingHours {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        String day = scanner.nextLine();

        boolean isValid = (hour >= 10 && hour <= 18);
        String openOrClosed = "";

        if (isValid) {
            switch (day) {
                case "Monday":
                case "Tuesday":
                case "Wednesday":
                case "Thursday":
                case "Friday":
                case "Saturday":
                    openOrClosed = "open";
                    break;
                case "Sunday":
                    openOrClosed = "closed";
                    break;
            }
        } else {
            openOrClosed = "closed";
        }
        System.out.printf("%s", openOrClosed);
    }
}
