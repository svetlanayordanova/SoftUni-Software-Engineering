package interfaces_and_abstraction_exercise.MilitaryElite_06.engineer;

import interfaces_and_abstraction_exercise.MilitaryElite_06.repair.Repair;

import java.util.Collection;

public interface Engineer {
    void addRepair(Repair repair);
    Collection<Repair> getRepairs();
}
