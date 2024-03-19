package polymorphism_exercise.Word_03;

import polymorphism_exercise.Word_03.CommandImpl;
import polymorphism_exercise.Word_03.CommandInterface;

public class Initialization {

    public static CommandInterface buildCommandInterface(StringBuilder text) {
        CommandInterface commandInterface = new CommandImpl(text);
        commandInterface.init();
        return commandInterface;
    }
}
