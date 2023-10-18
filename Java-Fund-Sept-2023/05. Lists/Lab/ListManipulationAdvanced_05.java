package lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced_05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String[] command = scanner.nextLine().split(" ");

        while (!command[0].equals("end")) {
            switch (command[0]) {
                case "Contains":
                    int num = Integer.parseInt(command[1]);

                    if (numbers.contains(num)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    if (command[1].equals("even")) {
                        for (int evenNum : numbers) {
                            if (evenNum % 2 == 0) {
                                System.out.printf("%d ", evenNum);
                            }
                        }
                    } else if (command[1].equals("odd")) {
                        for (int oddNum : numbers) {
                            if (oddNum % 2 != 0) {
                                System.out.printf("%d ", oddNum);
                            }
                        }
                    }

                    System.out.println();
                    break;
                case "Get":
                    int sum = 0;

                    for (int number : numbers) {
                        sum += number;
                    }

                    System.out.println(sum);
                    break;
                case "Filter":
                    int number = Integer.parseInt(command[2]);

                    if (command[1].equals("<")) {
                        for (int n : numbers) {
                            if (n < number) {
                                System.out.printf("%d ", n);
                            }
                        }

                        System.out.println();
                    } else if (command[1].equals(">")) {
                        for (int n : numbers) {
                            if (n > number) {
                                System.out.printf("%d ", n);
                            }
                        }

                        System.out.println();
                    } else if (command[1].equals(">=")) {
                        for (int n : numbers) {
                            if (n >= number) {
                                System.out.printf("%d ", n);
                            }
                        }

                        System.out.println();
                    } else if (command[1].equals("<=")) {
                        for (int n : numbers) {
                            if (n <= number) {
                                System.out.printf("%d ", n);
                            }
                        }

                        System.out.println();
                    }
                    break;
            }

            command = scanner.nextLine().split(" ");
        }
    }
}