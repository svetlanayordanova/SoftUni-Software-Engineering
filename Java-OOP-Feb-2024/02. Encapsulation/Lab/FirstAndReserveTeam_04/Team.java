package encapsulation.FirstAndReserveTeam_04;

import encapsulation.FirstAndReserveTeam_04.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private List<Person> firstTeam;
    private List<Person> reserveTeam;

    public Team(String name) {
        this(name, new ArrayList<>(), new ArrayList<>());
    }

    public Team(String name, List<Person> firstTeam, List<Person> reverseTeam) {
        this.setName(name);
        this.firstTeam = firstTeam;
        this.reserveTeam = reverseTeam;
    }

    public String getName() {
        return name;
    }

    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(firstTeam);
    }

    public List<Person> getReserveTeam() {
        return Collections.unmodifiableList(reserveTeam);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPlayer(Person person) {
        if (person.getAge() < 40) {
            this.firstTeam.add(person);
        } else {
            this.reserveTeam.add(person);
        }
    }
}
