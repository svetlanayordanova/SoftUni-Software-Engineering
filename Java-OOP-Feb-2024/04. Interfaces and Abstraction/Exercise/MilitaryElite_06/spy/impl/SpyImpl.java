package interfaces_and_abstraction_exercise.MilitaryElite_06.spy.impl;

import interfaces_and_abstraction_exercise.MilitaryElite_06.soldier.impl.SoldierImpl;
import interfaces_and_abstraction_exercise.MilitaryElite_06.spy.Spy;

public class SpyImpl extends SoldierImpl implements Spy {
    private int codeNumber;

    public SpyImpl(int id, String firstName, String lastName, int codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public int getCodeNumber() {
        return codeNumber;
    }
}