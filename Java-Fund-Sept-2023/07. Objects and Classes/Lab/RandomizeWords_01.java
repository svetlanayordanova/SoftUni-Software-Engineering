package objects_and_classes;

import java.util.*;
import java.util.stream.Collectors;

public class RandomizeWords_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> inputWords = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        Random random = new Random();

        int inputWordsLen = inputWords.size();

        for (int i = 0; i < inputWordsLen; i++) {
            int index = random.nextInt(inputWords.size());

            System.out.println(inputWords.get(index));
            inputWords.remove(index);
        }
    }
}