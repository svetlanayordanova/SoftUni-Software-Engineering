package iterators_and_comparators_exercise.ListyIterator_01;

import iterators_and_comparators_exercise.Collection_02.ListyIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        ListyIterator listyIterator = new ListyIterator<>();

        while (!"END".equals(line)) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Create":
                    String[] elements = Arrays.stream(line.split("\\s+"))
                            .skip(1).toArray(String[]::new);
                    listyIterator = new ListyIterator<>(elements);
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;

            }

            line = scanner.nextLine();
        }
    }
}
