package maps_lambda_and_streamAPI;

import java.util.*;

public class OddOccurrences_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] words = Arrays.stream(scanner.nextLine().split(" "))
                .map(word -> word.toLowerCase())
                .toArray(String[]::new);

        LinkedHashMap<String, Integer> wordsMap = new LinkedHashMap<>();

        for (String word : words) {
            if (wordsMap.containsKey(word)) {
                wordsMap.put(word, wordsMap.get(word) + 1);
            } else {
                wordsMap.put(word, 1);
            }
        }

//        String[] result = wordsMap
//                .entrySet()
//                .stream()
//                .filter(entry -> entry.getValue() % 2 != 0)
//                .map(entry -> entry.getKey())
//                .toArray(String[]::new);

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                result.add(entry.getKey());
            }
        }

        System.out.println(String.join(", ", result));
    }
}