package lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();

        int firstListIdx = 0;
        int secondListIdx = 0;

        boolean isFirstListTurn = true;

        while (firstListIdx < firstList.size() && secondListIdx < secondList.size()) {
            if (isFirstListTurn) {
                result.add(firstList.get(firstListIdx));
                firstListIdx++;
                isFirstListTurn = false;
            } else {
                result.add(secondList.get(secondListIdx));
                secondListIdx++;
                isFirstListTurn = true;
            }
        }

        //ако първият списък е с повече елементи от втория, допълваме с оставащите елементи
        for (int i = firstListIdx; i < firstList.size(); i++) {
            result.add(firstList.get(i));
        }
        
        //ако вторият списък е с повече елементи от първия, допълваме с оставащите елементи
        for (int i = secondListIdx; i < secondList.size(); i++) {
            result.add(secondList.get(i));
        }

        for (int num : result) {
            System.out.printf("%d ", num);
        }
    }
}