package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                return this.roster.remove(player);
            }
        }

        return false;
    }

    public void promotePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                if (!player.getRank().equals("Member")) {
                    player.setRank("Member");
                }
            }

            break;
        }
    }

    public void demotePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                if (!player.getRank().equals("Trial")) {
                    player.setRank("Trial");
                }
            }

            break;
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        Player[] kickedPlayers =
                this.roster.stream()
                        .filter(player -> player.getClazz().equals(clazz))
                        .toArray(Player[]::new);

        this.roster.removeIf(player -> player.getClazz().equals(clazz));

        return kickedPlayers;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Players in the guild: " + this.name + ":");
        this.roster.forEach(player -> {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(player.toString());
        });

        return stringBuilder.toString().trim();
    }
}