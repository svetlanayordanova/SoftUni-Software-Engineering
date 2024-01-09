package final_exam_preparation;

import java.util.*;

public class ThePianist_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, String> pieceComposers = new LinkedHashMap<>();
        Map<String, String> pieceKeys = new LinkedHashMap<>();


        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split("\\|");
            String piece = input[0];
            String composer = input[1];
            String key = input[2];

            pieceComposers.putIfAbsent(piece, composer);
            pieceKeys.putIfAbsent(piece, key);
        }

        String command = scanner.nextLine();

        while (!command.equals("Stop")) {
            String commandName = command.split("\\|")[0];
            String piece = command.split("\\|")[1];

            switch (commandName) {
                case "Add":
                    String composer = command.split("\\|")[2];
                    String key = command.split("\\|")[3];

                    if (pieceComposers.containsKey(piece)) {
                        System.out.printf("%s is already in the collection!%n", piece);
                    } else {
                        pieceComposers.put(piece, composer);
                        pieceKeys.put(piece, key);

                        System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                    }
                    break;
                case "Remove":
                    if (pieceComposers.containsKey(piece)) {
                        pieceComposers.remove(piece);
                        pieceKeys.remove(piece);

                        System.out.printf("Successfully removed %s!%n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
                case "ChangeKey":
                    String newKey = command.split("\\|")[2];

                    if (pieceKeys.containsKey(piece)) {
                        pieceKeys.put(piece, newKey);
                        System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        pieceComposers.entrySet()
                .forEach(entry -> {
                    String piece = entry.getKey();
                    String composer = entry.getValue();
                    String key = pieceKeys.get(piece);
                    System.out.printf("%s -> Composer: %s, Key: %s%n", piece, composer, key);
                });
    }
}