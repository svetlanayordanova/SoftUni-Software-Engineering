package basics_recap_exercise;

import java.util.Scanner;
public class Vacation_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        String groupType = scanner.nextLine();
        String day = scanner.nextLine();

        double sum = 0;

        switch (groupType) {
            case "Students":
                if (day.equals("Friday")) {
                    sum = people * 8.45;
                } else if (day.equals("Saturday")) {
                    sum = people * 9.80;
                } else if (day.equals("Sunday")) {
                    sum = people * 10.46;
                }

                if (people >= 30) {
                    sum = sum - sum * 0.15;
                }
                break;
            case "Business":
                if (day.equals("Friday")) {
                    sum = people * 10.90;
                    if (people >= 100) {
                        sum = (people - 10) * 10.90;
                    }
                } else if (day.equals("Saturday")) {
                    sum = people * 15.60;
                    if (people >= 100) {
                        sum = (people - 10) * 15.60;
                    }
                } else if (day.equals("Sunday")) {
                    sum = people * 16;
                    if (people >= 100) {
                        sum = (people - 10) * 16;
                    }
                }
                break;
            case "Regular":
                if (day.equals("Friday")) {
                    sum = people * 15;
                } else if (day.equals("Saturday")) {
                    sum = people * 20;
                } else if (day.equals("Sunday")) {
                    sum = people * 22.50;
                }

                if (people >= 10 && people <= 20) {
                    sum = sum - sum * 0.05;
                }
                break;
        }
        System.out.printf("Total price: %.2f", sum);
    }
}
