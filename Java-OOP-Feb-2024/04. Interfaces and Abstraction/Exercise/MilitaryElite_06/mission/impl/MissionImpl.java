package interfaces_and_abstraction_exercise.MilitaryElite_06.mission.impl;

import interfaces_and_abstraction_exercise.MilitaryElite_06.enumm.State;
import interfaces_and_abstraction_exercise.MilitaryElite_06.mission.Mission;

public class MissionImpl implements Mission {
    private String codeName;
    private State state;

    public MissionImpl(String codeName, String state) {
        this.codeName = codeName;
        this.setState(state);
    }

    @Override
    public String getCodeName() {
        return codeName;
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public void completeMission() {
        this.state = State.finished;
    }

    private void setState(String state) {
        this.state = State.valueOf(state);
    }
}
