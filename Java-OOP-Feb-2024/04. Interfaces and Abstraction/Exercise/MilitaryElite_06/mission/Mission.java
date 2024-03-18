package interfaces_and_abstraction_exercise.MilitaryElite_06.mission;

import interfaces_and_abstraction_exercise.MilitaryElite_06.enumm.State;

public interface Mission {
    String getCodeName();
    State getState(); // (Enumeration: "inProgress" or "finished")
    void completeMission();
}
