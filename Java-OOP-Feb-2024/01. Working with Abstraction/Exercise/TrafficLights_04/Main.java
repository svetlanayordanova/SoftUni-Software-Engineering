package working_with_abstraction_exercise.TrafficLights_04;

import java.util.Arrays;
import java.util.Scanner;

import static working_with_abstraction_exercise.TrafficLights_04.Signal.updateSignal;
import static working_with_abstraction_exercise.TrafficLights_04.Signal.printSignals;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Signal[] signals = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Signal::valueOf)
                .toArray(Signal[]::new);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            updateSignal(signals);

            printSignals(signals);
        }

    }
}