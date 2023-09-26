import java.util.Scanner;
public class TrekkingMania {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int groups = Integer.parseInt(scanner.nextLine());

        int groupOne = 0;
        int groupTwo = 0;
        int groupThree = 0;
        int groupFour = 0;
        int groupFive = 0;

        int totalPeople = 0;

        for (int currentGroup = 0; currentGroup < groups; currentGroup++) {

            int membersInTheGroups = Integer.parseInt(scanner.nextLine());
            totalPeople += membersInTheGroups;

            if (membersInTheGroups <= 5) {
                groupOne += membersInTheGroups;
            } else if (membersInTheGroups <= 12) {
                groupTwo += membersInTheGroups;
            } else if (membersInTheGroups <= 25) {
                groupThree += membersInTheGroups;
            } else if (membersInTheGroups <= 40) {
                groupFour += membersInTheGroups;
            } else {
                groupFive += membersInTheGroups;
            }
        }

            System.out.printf("%.02f%%%n", groupOne * 1.0 / totalPeople * 100);
            System.out.printf("%.02f%%%n", groupTwo * 1.0 / totalPeople * 100);
            System.out.printf("%.02f%%%n", groupThree * 1.0 / totalPeople * 100);
            System.out.printf("%.02f%%%n", groupFour * 1.0 / totalPeople * 100);
            System.out.printf("%.02f%%%n", groupFive * 1.0 / totalPeople * 100);

    }
}
