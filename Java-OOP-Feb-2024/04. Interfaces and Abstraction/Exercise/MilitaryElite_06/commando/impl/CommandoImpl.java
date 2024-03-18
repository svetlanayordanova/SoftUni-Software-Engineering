package interfaces_and_abstraction_exercise.MilitaryElite_06.commando.impl;

import interfaces_and_abstraction_exercise.MilitaryElite_06.commando.Commando;
import interfaces_and_abstraction_exercise.MilitaryElite_06.mission.Mission;
import interfaces_and_abstraction_exercise.MilitaryElite_06.soldier.impl.SpecialisedSoldierImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private Collection<Mission> missions;

    public CommandoImpl(int id,
                        String firstName,
                        String lastName,
                        double salary,
                        String corps,
                        Collection<Mission> missions) {
        super(id, firstName, lastName, salary, corps);
        this.setMissions(missions);
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return Collections.unmodifiableCollection(this.missions);
    }

    public void setMissions(Collection<Mission> missions) {
        if (null == missions) {
            this.missions = new ArrayList<>();
        } else {
            this.missions = missions;
        }
    }
}
