package lists_exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat_08 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("3:1")) {
            if (command.contains("merge")) {
                int startIndex = Integer.parseInt(command.split(" ")[1]);
                int endIndex = Integer.parseInt(command.split(" ")[2]);

                if (startIndex < 0) {
                    startIndex = 0;
                }

                if (endIndex > input.size() - 1) {
                    endIndex = input.size() - 1;
                }

                if (startIndex >= 0 && startIndex <= input.size() - 1 && endIndex >= 0 && endIndex <= input.size() - 1) {
                    String resultMerge = "";

                    for (int index = startIndex; index <= endIndex; index++) {
                        String currentElement = input.get(index);
                        resultMerge += currentElement;
                    }

                    for (int index = startIndex; index <= endIndex; index++) {
                        input.remove(startIndex);
                    }

                    input.add(startIndex, resultMerge);
                }
            } else if (command.contains("divide")) {
                int index = Integer.parseInt(command.split(" ")[1]);
                int parts = Integer.parseInt(command.split(" ")[2]);

                if (index >= 0 && index <= input.size() - 1) {
                    String textForDivide = input.get(index);
                    input.remove(index);

                    int countSymbolsPerPart = textForDivide.length() / parts;

                    int beginIndex = 0;

                    for (int part = 1; part < parts; part++) {
                        String textPerPart = textForDivide.substring(beginIndex, beginIndex + countSymbolsPerPart);
                        input.add(index, textPerPart);
                        index++;
                        beginIndex += countSymbolsPerPart;
                    }

                    String textLastParts = textForDivide.substring(beginIndex, textForDivide.length());
                    input.add(index, textLastParts);
                }
            }

            command = scanner.nextLine();
        }

        System.out.println(String.join(" ", input));
    }
}