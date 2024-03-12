package working_with_abstraction.StudentSystem_03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        while (true)
        {
            String[] arguments = scanner.nextLine().split(" ");
            String command = arguments[0];
            if ("Exit".equals(command)){
                break;
            }
            studentSystem.parseCommand(arguments);
        }
    }
}
