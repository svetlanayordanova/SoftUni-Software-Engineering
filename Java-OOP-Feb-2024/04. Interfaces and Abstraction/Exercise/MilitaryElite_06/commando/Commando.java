package interfaces_and_abstraction_exercise.MilitaryElite_06.commando;

import interfaces_and_abstraction_exercise.MilitaryElite_06.mission.Mission;

import java.util.Collection;

public interface Commando {
    void addMission(Mission mission);
    Collection<Mission> getMissions();
}
