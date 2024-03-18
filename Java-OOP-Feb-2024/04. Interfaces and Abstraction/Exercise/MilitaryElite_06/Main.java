package interfaces_and_abstraction_exercise.MilitaryElite_06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        /*
        Interfaces:
            Soldier - int getId(), String getFirstName(), String getLastName()
            Private - double getSalary()
            LieutenantGeneral - Collection<Private> getPrivates(), void addPrivate(Private priv)
            SpecialisedSoldier - String getCorps(); "Airforces" or "Marines" (Enumeration)
            Engineer - void addRepair(Repair interfaces_and_abstraction_exercise.MilitaryElite_06.repair), Collection<Repair> getRepairs()
            Repair - String getPartName(), int getWorkedHours()
            Commando - void addMission(Mission interfaces_and_abstraction_exercise.MilitaryElite_06.mission), Collection<Mission> getMissions()
            Mission - String getCodeName(), String getState() (Enumeration: "inProgress" or "finished"),
            void completeMission()
            Spy - int getCodeNumber()
         */
    }
}
