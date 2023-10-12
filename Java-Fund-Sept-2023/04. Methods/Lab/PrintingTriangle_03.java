package methods;

import java.util.Scanner;
public class PrintingTriangle_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        printFigure(size);
    }

    public static void printFigure(int size) {
        for (int i = 1; i <= size; i++) {
            printRow(i);
        }

        for (int i = size - 1; i >= 1; i--) {
            printRow(i);
        }
    }

    public static void printRow(int elementsCount) {
        for (int i = 1; i <= elementsCount; i++) {
            System.out.print(i + " ");
        }

        System.out.println();
    }
}