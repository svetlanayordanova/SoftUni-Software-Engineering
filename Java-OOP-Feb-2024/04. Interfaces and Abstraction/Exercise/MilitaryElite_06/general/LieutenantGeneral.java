package interfaces_and_abstraction_exercise.MilitaryElite_06.general;

import interfaces_and_abstraction_exercise.MilitaryElite_06.privvate.Private;

import java.util.Collection;

public interface LieutenantGeneral {
    Collection<Private> getPrivates();
    void addPrivate(Private priv);
}
