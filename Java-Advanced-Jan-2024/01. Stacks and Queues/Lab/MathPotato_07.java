package stacks_and_queues;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MathPotato_07 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        PriorityQueue<String> priorityQueue = new PriorityQueue<>();

        for (String child : children) {
            priorityQueue.offer(child);
        }

        int cycle = 1;

        while (priorityQueue.size() > 1) {
            for (int i = 1; i < n; i++) {
                priorityQueue.offer(priorityQueue.poll());
            }

            if (isPrime(cycle)) {
                System.out.println("Prime " + priorityQueue.peek());
            } else {
                System.out.println("Removed " + priorityQueue.poll());
            }

            cycle++;
        }

        System.out.println("Last is " + priorityQueue.poll());
    }

    public static boolean isPrime(int cycle) {
        boolean isPrime = true;

        for (int i = 2; i < cycle; i++) {
            if (cycle % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (cycle == 1) {
            return false;
        }

        return isPrime;
    }
}