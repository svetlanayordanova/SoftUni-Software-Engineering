package interfaces_and_abstraction_exercise.MilitaryElite_06.soldier.impl;

import interfaces_and_abstraction_exercise.MilitaryElite_06.enumm.Corp;
import interfaces_and_abstraction_exercise.MilitaryElite_06.privvate.impl.PrivateImpl;
import interfaces_and_abstraction_exercise.MilitaryElite_06.soldier.SpecialisedSoldier;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private Corp corps;

    public SpecialisedSoldierImpl(int id,
                                  String firstName,
                                  String lastName,
                                  double salary,
                                  String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    @Override
    public Corp getCorps() {
        return corps;
    }

    public void setCorps(String corps) {
        this.corps = Corp.valueOf(corps);
    }
}
