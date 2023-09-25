import java.util.Scanner;
public class SchoolCamp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        String typeGroup = scanner.nextLine();
        int numStudents = Integer.parseInt(scanner.nextLine());
        int numNights = Integer.parseInt(scanner.nextLine());

        double allPrice = 0;
        double pricePerNight = 0;
        String sport = "";

        if (season.equals("Winter")) {
            if (typeGroup.equals("girls")) {
                sport = "Gymnastics";
            } else if (typeGroup.equals("boys")) {
                sport = "Judo";
            } else if (typeGroup.equals("mixed")) {
                sport = "Ski";
            }

        } else if (season.equals("Spring")) {
            if (typeGroup.equals("girls")) {
                sport = "Athletics";
            } else if (typeGroup.equals("boys")) {
                sport = "Tennis";
            } else if (typeGroup.equals("mixed")) {
                sport = "Cycling";
            }

        } else if (season.equals("Summer")) {
            if (typeGroup.equals("girls")) {
                sport = "Volleyball";
            } else if (typeGroup.equals("boys")) {
                sport = "Football";
            } else if (typeGroup.equals("mixed")) {
                sport = "Swimming";
            }
        }

        if (season.equals("Winter")) {
            if (typeGroup.equals("boys") || typeGroup.equals("girls")) {
                pricePerNight = 9.60;
            } else if (typeGroup.equals("mixed")) {
                pricePerNight = 10.0;
            }
        } else if (season.equals("Spring")) {
            if (typeGroup.equals("boys") || typeGroup.equals("girls")) {
                pricePerNight = 7.20;
            } else if (typeGroup.equals("mixed")) {
                pricePerNight = 9.50;
            }
        } else if (season.equals("Summer")) {
            if (typeGroup.equals("boys") || typeGroup.equals("girls")) {
                pricePerNight = 15.0;
            } else if (typeGroup.equals("mixed")) {
                pricePerNight = 20.0;
            }
        }

        allPrice = numStudents * pricePerNight * numNights;

        if (numStudents >= 50) {
            allPrice = allPrice * 0.50;
        } else if (numStudents >= 20) {
            allPrice = allPrice - (allPrice * 0.15);
        } else if (numStudents >= 10) {
            allPrice = allPrice - (allPrice * 0.05);
        }
        System.out.printf ("%s %.2f lv.", sport, allPrice);
    }
}

