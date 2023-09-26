import java.util.Scanner;
public class Cinema {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String movieName = scanner.nextLine();

        int studentTickets = 0;
        int standardTickets = 0;
        int kidTickets = 0;
        int totalStudentTickets = 0;
        int totalStandardTickets = 0;
        int totalKidTickets = 0;
        int totalTickets = 0;

        while (!movieName.equals("Finish")) {
            int seats = Integer.parseInt(scanner.nextLine());
            String ticketType = scanner.nextLine();

            while (!ticketType.equals("End")) {
                switch (ticketType) {
                    case "student":
                        studentTickets++;
                        totalStudentTickets += studentTickets;
                        break;
                    case "standard":
                        standardTickets++;
                        totalStandardTickets += standardTickets;
                        break;
                    case "kid":
                        kidTickets++;
                        totalKidTickets += kidTickets;
                        break;
                }

                totalTickets = totalStudentTickets + totalStandardTickets + totalKidTickets;

                if (totalTickets > seats) {
                    break;
                }

                ticketType = scanner.nextLine();
            }

            System.out.printf("%s - %.2f%% full.%n", movieName, (totalTickets * 100.0) / seats);

            movieName = scanner.nextLine();

        }
        System.out.printf("Total tickets: %d%n", totalTickets);
        System.out.printf("%.2f%% student tickets.%n", (totalStudentTickets * 100.0) / totalTickets);
        System.out.printf("%.2f%% standard tickets.%n", (totalStandardTickets * 100.0) / totalTickets);
        System.out.printf("%.2f%% kid tickets.%n", (totalKidTickets * 100.0) / totalTickets);
    }
}
