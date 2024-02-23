package generics_exercise.GenericCountMethodString_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Box<String>> boxList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            Box<String> box = new Box<>(line);
            boxList.add(box);
        }

        Box<String> stringBox = new Box<>(scanner.nextLine());
        int count = count(boxList, stringBox);
        System.out.println(count);
    }

    static <T extends Comparable<T>> int count(List<T> list, T element) {
        int count = 0;

        for (T el : list) {
            int result = el.compareTo(element);
            //връща 1, ако el > element
            //връща -1, ако el < element
            //връща 0, ако el == element

            if (result > 0) {
                count++;
            }
        }

        return count;
    }
}