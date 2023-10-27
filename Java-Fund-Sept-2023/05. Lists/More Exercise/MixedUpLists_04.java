package lists_more_exercise;

import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> resultList = new ArrayList<>();

        int firstBorder = 0;
        int secondBorder = 0;

        if (firstList.size() > secondList.size()) {
            firstBorder = firstList.get(firstList.size() - 1);
            secondBorder = firstList.get(firstList.size() - 2);
        } else {
            firstBorder = secondList.get(0);
            secondBorder = secondList.get(1);
        }

        if (firstBorder < secondBorder) {
            for (int num : firstList) {
                if (num > firstBorder && num < secondBorder) {
                    resultList.add(num);
                }
            }

            for (int num : secondList) {
                if (num > firstBorder && num < secondBorder) {
                    resultList.add(num);
                }
            }
        } else {
            for (int num : firstList) {
                if (num > secondBorder && num < firstBorder) {
                    resultList.add(num);
                }
            }

            for (int num : secondList) {
                if (num > secondBorder && num < firstBorder) {
                    resultList.add(num);
                }
            }
        }

        Collections.sort(resultList);

        for (int num : resultList) {
            System.out.print(num + " ");
        }
    }
}