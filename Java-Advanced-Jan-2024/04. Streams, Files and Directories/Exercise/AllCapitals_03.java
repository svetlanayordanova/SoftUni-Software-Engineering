package streams_files_and_directories_exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AllCapitals_03 {
    public static void main(String[] args) {

        String inputPath = "C:\\Users\\Svetlana\\IdeaProjects\\Java-Advanced-Jan-2024\\src\\streams_files_and_directories_exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "C:\\Users\\Svetlana\\IdeaProjects\\Java-Advanced-Jan-2024\\src\\streams_files_and_directories_exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(inputPath));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(outputPath))) {

            String line = bufferedReader.readLine();

            while (line != null) {
                bufferedWriter.write(line.toUpperCase());
                bufferedWriter.write(System.lineSeparator());
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
