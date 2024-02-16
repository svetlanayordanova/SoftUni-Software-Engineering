package streams_files_and_directories_exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MergeTwoFiles_07 {
    public static void main(String[] args) {

        String firstInputPath = "C:\\Users\\Svetlana\\IdeaProjects\\Java-Advanced-Jan-2024\\src\\streams_files_and_directories_exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String secondInputPath = "C:\\Users\\Svetlana\\IdeaProjects\\Java-Advanced-Jan-2024\\src\\streams_files_and_directories_exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String outputPath = "C:\\Users\\Svetlana\\IdeaProjects\\Java-Advanced-Jan-2024\\src\\streams_files_and_directories_exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output4.txt";

        try (BufferedReader firstBufferedReader = Files.newBufferedReader(Path.of(firstInputPath));
             BufferedReader secondBufferedReader = Files.newBufferedReader(Path.of(secondInputPath));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(outputPath))) {

            String firstLine = firstBufferedReader.readLine();

            while (firstLine != null) {
                bufferedWriter.write(firstLine);
                bufferedWriter.write(System.lineSeparator());

                firstLine = firstBufferedReader.readLine();
            }

            String secondLine = secondBufferedReader.readLine();

            while (secondLine != null) {
                bufferedWriter.write(secondLine);
                bufferedWriter.write(System.lineSeparator());

                secondLine = secondBufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
