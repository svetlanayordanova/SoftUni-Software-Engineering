package exam_preparation;

import java.util.*;
import java.util.stream.Collectors;

public class Meeting_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> malesStack = new ArrayDeque<>();
        Deque<Integer> femalesQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(malesStack::push);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(femalesQueue::offer);

        int countMatches = 0;

        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {
            for (Integer male : malesStack) {
                if (male <= 0) {
                    malesStack.remove();
                }
            }

            for (Integer female : femalesQueue) {
                if (female <= 0) {
                    femalesQueue.remove();
                }
            }

            int male = malesStack.pop();
            int female = femalesQueue.poll();

            if (female % 25 == 0) {
                femalesQueue.poll();
            } else if (male % 25 == 0) {
                malesStack.pop();
            }

            if (male == female) {
                countMatches++;
            } else {
                male -= 2;
                malesStack.push(male);
            }
        }

        System.out.println("Matches: " + countMatches);
        if (malesStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.println("Males left: " + malesStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (femalesQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.println("Females left: " + femalesQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }
}