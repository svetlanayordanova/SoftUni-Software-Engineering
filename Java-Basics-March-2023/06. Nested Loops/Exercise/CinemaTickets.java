import java.util.Scanner;
public class CinemaTickets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String movieName = scanner.nextLine();

        int allTickets = 0;
        int allStudentTickets = 0;
        int allStandardTickets = 0;
        int allKidTickets = 0;

        while (!movieName.equals("Finish")) {

            int freeSeats = Integer.parseInt(scanner.nextLine());
            String typeName = scanner.nextLine();

            int countStudentTickets = 0;
            int countStandardTickets = 0;
            int countKidTickets = 0;
            int currentMovieTickets = 0;

            while (!typeName.equals("End")) {

                if (typeName.equals("student")) {
                    countStudentTickets++;
                } else if (typeName.equals("standard")) {
                    countStandardTickets++;
                } else if (typeName.equals("kid")) {
                    countKidTickets++;
                }

                currentMovieTickets = countStudentTickets + countStandardTickets + countKidTickets;

                if (freeSeats <= currentMovieTickets) {
                    break;
                }

                typeName = scanner.nextLine();

            }

            allStudentTickets += countStudentTickets;
            allStandardTickets += countStandardTickets;
            allKidTickets += countKidTickets;
            allTickets += currentMovieTickets;

            double percentCapacity = currentMovieTickets * 100.0 / freeSeats;

            System.out.printf("%s - %.2f%% full.%n", movieName, percentCapacity);

            movieName = scanner.nextLine();
        }

        double percentStudentTickets = allStudentTickets * 100.0 / allTickets;
        double percentStandardTickets = allStandardTickets * 100.0 / allTickets;
        double percentKidTickets = allKidTickets * 100.0 / allTickets;

        System.out.printf("Total tickets: %d%n", allTickets);
        System.out.printf("%.2f%% student tickets.%n", percentStudentTickets);
        System.out.printf("%.2f%% standard tickets.%n", percentStandardTickets);
        System.out.printf("%.2f%% kids tickets.", percentKidTickets);
    }
}