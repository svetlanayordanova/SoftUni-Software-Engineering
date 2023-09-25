import java.util.Scanner;
public class SleepyTomCat {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int daysOff = Integer.parseInt(scanner.nextLine());

        double minutesPerYear = 30000;
        int minutesPerWorkingDay = 63;
        int minutesPerDayOff = 127;
        int workingDays = 365 - daysOff;
        double playingTimePerYearInMinutes = (workingDays * minutesPerWorkingDay) + (daysOff * minutesPerDayOff);
        double differenceInHours = Math.abs((minutesPerYear - playingTimePerYearInMinutes) / 60);
        double differenceInMinutes = Math.abs((minutesPerYear - playingTimePerYearInMinutes) % 60);

        if (playingTimePerYearInMinutes > minutesPerYear) {
            System.out.println("Tom will run away");
            System.out.printf("%.0f hours and %.0f minutes more for play", Math.floor(differenceInHours), Math.floor(differenceInMinutes));
        } else {
            System.out.println("Tom sleeps well");
            System.out.printf("%.0f hours and %.0f minutes less for play", Math.floor(differenceInHours), Math.floor(differenceInMinutes));
        }
    }
}
