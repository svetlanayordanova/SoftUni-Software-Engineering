package exam_preparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OSPlaning_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> tasksStack = new ArrayDeque<>();
        Deque<Integer> threadsQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(tasksStack::push);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(threadsQueue::offer);

        int taskValueToBeKilled = Integer.parseInt(scanner.nextLine());

        while (tasksStack.peek() != taskValueToBeKilled) {
            int thread = threadsQueue.poll();
            int task = tasksStack.pop();

            if (thread < task) {
                tasksStack.push(task);
            }
        }

        System.out.printf("Thread with value %d killed task %d%n", threadsQueue.peek(), taskValueToBeKilled);
        System.out.println(threadsQueue.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}