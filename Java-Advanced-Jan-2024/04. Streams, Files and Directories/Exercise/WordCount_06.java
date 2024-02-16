package streams_files_and_directories_exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

public class WordCount_06 {
    public static void main(String[] args) {

        String firstInputPath = "C:\\Users\\Svetlana\\IdeaProjects\\Java-Advanced-Jan-2024\\src\\streams_files_and_directories_exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String secondInputPath = "C:\\Users\\Svetlana\\IdeaProjects\\Java-Advanced-Jan-2024\\src\\streams_files_and_directories_exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        String outputPath = "C:\\Users\\Svetlana\\IdeaProjects\\Java-Advanced-Jan-2024\\src\\streams_files_and_directories_exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output3.txt";

        Map<String, Integer> countFoundWords = new LinkedHashMap<>();

        try (BufferedReader firstBufferedReader = Files.newBufferedReader(Path.of(firstInputPath));
             BufferedReader secondBufferedReader = Files.newBufferedReader(Path.of(secondInputPath));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(outputPath))) {

            String firstLine = firstBufferedReader.readLine();
            String secondLine = secondBufferedReader.readLine();

            while (firstLine != null) {
                String[] firstLineParts = firstLine.split("\\s+");
                String[] secondLineParts = secondLine.split("\\s+");

                for (int i = 0; i < firstLineParts.length; i++) {
                    for (int j = 0; j < secondLineParts.length; j++) {
                        if (secondLineParts[j].equals(firstLineParts[i])) {
                            countFoundWords.putIfAbsent(firstLineParts[i], 0);
                            countFoundWords.put(firstLineParts[i], countFoundWords.get(firstLineParts[i]) + 1);
                        }
                    }
                }

                firstLine = firstBufferedReader.readLine();
            }

            countFoundWords.forEach((k, v) -> {
                try {
                    bufferedWriter.write(String.format("%s - %d", k, v));
                    bufferedWriter.write(System.lineSeparator());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}