import java.util.Scanner;
public class CircleAreaAndPerimeter2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double r = Double.parseDouble(scanner.nextLine());

        String calculatedArea = "<calculated area>";
        double area = Math.PI * r * r;
        System.out.printf("%s %.2f%n", calculatedArea, area);

        String calculatedPerimeter = "<calculated perimeter>";
        double perimeter = 2 * Math.PI * r;
        System.out.printf("%s %.2f", calculatedPerimeter, perimeter);

    }
}
