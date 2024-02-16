package streams_files_and_directories_exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

public class CountCharacterTypes_04 {
    public static void main(String[] args) {

        String inputPath = "C:\\Users\\Svetlana\\IdeaProjects\\Java-Advanced-Jan-2024\\src\\streams_files_and_directories_exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "C:\\Users\\Svetlana\\IdeaProjects\\Java-Advanced-Jan-2024\\src\\streams_files_and_directories_exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output2.txt";

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> punctuations = Set.of('!', ',', '.', '?');

        int vowelsCount = 0;
        int punctuationsCount = 0;
        int othersCount = 0;
        
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(inputPath));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(outputPath))) {

            String line = bufferedReader.readLine();

            while (line != null) {
                for (char c : line.toCharArray()) {
                    if (vowels.contains(c)) {
                        vowelsCount++;
                    } else if (punctuations.contains(c)) {
                        punctuationsCount++;
                    } else if (c != ' ') {
                        othersCount++;
                    }
                }

                line = bufferedReader.readLine();
            }

            bufferedWriter.write(String.format("Vowels: %d", vowelsCount));
            bufferedWriter.write(System.lineSeparator());
            bufferedWriter.write(String.format("Other symbols: %d", othersCount));
            bufferedWriter.write(System.lineSeparator());
            bufferedWriter.write(String.format("Punctuation: %d", punctuationsCount));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
