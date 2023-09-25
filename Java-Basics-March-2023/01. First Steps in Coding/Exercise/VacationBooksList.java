import java.util.Scanner;

public class VacationBooksList {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //1.Четем от конзолата
        int numberOfPages = Integer.parseInt(scanner.nextLine ());
        int pagesPerHour = Integer.parseInt(scanner.nextLine ());
        int days = Integer.parseInt(scanner.nextLine ());

        //2.Изчисления
        int totalHours = numberOfPages / pagesPerHour;
        int hoursPerDay = totalHours / days;

        //3.Принтиране на конзолата
        System.out.println(hoursPerDay);

    }
}
