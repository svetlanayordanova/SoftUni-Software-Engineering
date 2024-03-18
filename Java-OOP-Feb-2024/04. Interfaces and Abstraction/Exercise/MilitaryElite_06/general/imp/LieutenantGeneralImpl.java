package interfaces_and_abstraction_exercise.MilitaryElite_06.general.impl;

import interfaces_and_abstraction_exercise.MilitaryElite_06.general.LieutenantGeneral;
import interfaces_and_abstraction_exercise.MilitaryElite_06.privvate.Private;
import interfaces_and_abstraction_exercise.MilitaryElite_06.privvate.impl.PrivateImpl;

import java.util.Collection;
import java.util.Collections;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private Collection<Private> privates;

    public LieutenantGeneralImpl(int id,
                                 String firstName,
                                 String lastName,
                                 double salary,
                                 Collection<Private> privates) {
        super(id, firstName, lastName, salary);
        this.privates = privates;
    }

    @Override
    public Collection<Private> getPrivates() {
        return Collections.unmodifiableCollection(this.privates);
    }

    @Override
    public void addPrivate(Private priv) {
        this.privates.add(priv);
    }
}
