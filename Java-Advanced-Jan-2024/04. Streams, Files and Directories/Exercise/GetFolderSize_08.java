package streams_files_and_directories_exercise;

import java.io.File;

public class GetFolderSize_08 {
    public static void main(String[] args) {

        String path = "C:\\Users\\Svetlana\\IdeaProjects\\Java-Advanced-Jan-2024\\src\\streams_files_and_directories_exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File directory = new File(path);
        int size = 0;

        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                size += file.length();
            }
        }

        System.out.printf("Folder size: %d", size);
    }
}
