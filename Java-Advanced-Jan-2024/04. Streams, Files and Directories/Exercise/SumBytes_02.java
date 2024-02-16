package streams_files_and_directories_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumBytes_02 {
    public static void main(String[] args) {

        String path = "C:\\Users\\Svetlana\\IdeaProjects\\Java-Advanced-Jan-2024\\src\\streams_files_and_directories_exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(path))) {
            String line = bufferedReader.readLine();

            int sum = 0;

            while (line != null) {

                for (char c : line.toCharArray()) {
                    sum += c;
                }

                line = bufferedReader.readLine();
            }
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
