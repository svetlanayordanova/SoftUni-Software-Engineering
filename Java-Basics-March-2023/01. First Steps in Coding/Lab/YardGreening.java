import java.util.Scanner;
public class YardGreening {

    public static void main (String [] args) {

        Scanner scanner = new Scanner (System.in);

        double allSqm = Double.parseDouble (scanner.nextLine ());

        double amount = allSqm * 7.61;

        double discount = amount * 0.18;

        double sumAfterDiscount = amount - discount;

        System.out.printf ("The final price is: %f lv. %n", sumAfterDiscount);

        System.out.printf ("The discount is: %f lv.", discount);

    }
}
