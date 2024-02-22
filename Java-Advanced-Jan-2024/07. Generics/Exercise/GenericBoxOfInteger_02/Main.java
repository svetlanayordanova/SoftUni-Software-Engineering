package generics_exercise.GenericBoxOfInteger_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Box<Integer>> boxList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            Box<Integer> box = new Box<>(number);
            boxList.add(box);
        }

        boxList.forEach(System.out::println);
    }
}