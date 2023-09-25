import java.util.Scanner;
public class OnTimeForTheExam {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int examHour = Integer.parseInt(scanner.nextLine());
        int examMinutes = Integer.parseInt(scanner.nextLine());
        int arrivalHour = Integer.parseInt(scanner.nextLine());
        int arrivalMinutes = Integer.parseInt(scanner.nextLine());

        int examTimeInMinutes = (examHour * 60) + examMinutes;
        int arrivalTimeInMinutes = (arrivalHour * 60) + arrivalMinutes;
        int diff = Math.abs(examTimeInMinutes - arrivalTimeInMinutes);

        if (examTimeInMinutes < arrivalTimeInMinutes) {
            System.out.println("Late");
            int hours = diff / 60;
            int minutes = diff % 60;

            if (diff < 60) {
                System.out.printf("%d minutes after the start", diff);
            } else {
                System.out.printf("%d:%02d hours after the start", hours, minutes);
            }
        }

        if (examTimeInMinutes >= arrivalTimeInMinutes && diff <= 30) {
            if (examTimeInMinutes == arrivalTimeInMinutes) {
                System.out.println("On time");
            } else {
                System.out.println("On time");
                System.out.printf("%d minutes before the start", diff);
            }
        }

        if (examTimeInMinutes > arrivalTimeInMinutes && diff > 30) {
            System.out.println("Early");
            int hours = diff / 60;
            int minutes = diff % 60;

            if (diff < 60) {
                System.out.printf("%d minutes before the start", diff);
            } else {
                System.out.printf("%d:%02d hours before the start", hours, minutes);
            }
        }
    }
}
