package exam_preparation;

import java.util.*;

public class FoodFinder_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Queue<String> vowels = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(vowels::offer);

        Stack<String> consonants = new Stack<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(consonants::push);

        Map<String, List<String>> words = new LinkedHashMap<>();
        words.put("pear", new ArrayList<>());
        words.put("flour", new ArrayList<>());
        words.put("pork", new ArrayList<>());
        words.put("olive", new ArrayList<>());

        while (!consonants.isEmpty()) {
            String firstVowel = vowels.poll();
            vowels.offer(firstVowel);
            String lastConsonant = consonants.pop();

            for (Map.Entry<String, List<String>> entry : words.entrySet()) {
                String word = entry.getKey();

                if (word.contains(firstVowel)) {
                    if (!words.get(word).contains(firstVowel)) {
                        words.get(word).add(firstVowel);
                    }
                }

                if (word.contains(lastConsonant)) {
                    if (!words.get(word).contains(lastConsonant)) {
                        words.get(word).add(lastConsonant);
                    }
                }
            }
        }

        List<String> foundWords = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : words.entrySet()) {
            String word = entry.getKey();
            List<String> letters = entry.getValue();

            if (word.length() == letters.size()) {
                foundWords.add(word);
            }
        }

        System.out.println("Words found: " + foundWords.size());
        foundWords.forEach(System.out::println);
    }
}