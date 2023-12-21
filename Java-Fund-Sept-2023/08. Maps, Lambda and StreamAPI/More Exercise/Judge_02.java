package maps_lambda_and_streamAPI_more_exercise;

import java.util.*;

public class Judge_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> contests = new LinkedHashMap<>();
        Map<String, Map<String, Integer>> users = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("no more time")) {
            String[] inputParts = input.split(" -> ");
            String username = inputParts[0];
            String contest = inputParts[1];
            int points = Integer.parseInt(inputParts[2]);

            if (!contests.containsKey(contest)) {
                contests.put(contest, new LinkedHashMap<>());
                contests.get(contest).put(username, points);
                users.putIfAbsent(username, new LinkedHashMap<>());
                users.get(username).put(contest, points);
            } else {
                if (!contests.get(contest).containsKey(username)) {
                    contests.get(contest).put(username, points);
                    users.putIfAbsent(username, new LinkedHashMap<>());
                    users.get(username).put(contest, points);
                } else {
                    if (points > contests.get(contest).get(username)) {
                        contests.get(contest).put(username, points);
                        users.get(username).put(contest, points);
                    }
                }
            }

            input = scanner.nextLine();
        }

        Map<String, Integer> totalPoints = new LinkedHashMap<>();

        users.entrySet().forEach(entry -> {
            String user = entry.getKey();
            Map<String, Integer> contestPoints = entry.getValue();
            int totalPointsPerUser = 0;

            for (Map.Entry<String, Integer> entry1 : contestPoints.entrySet()) {
                int points = entry1.getValue();
                totalPointsPerUser += points;
            }

            totalPoints.put(user, totalPointsPerUser);
        });

        contests.entrySet().forEach(entry -> {
            String contest = entry.getKey();
            Map<String, Integer> userPoints = entry.getValue();
            System.out.printf("%s: %d participants%n", contest, userPoints.size());

            final int[] position = {1};
            userPoints
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                            .thenComparing(Map.Entry.comparingByKey()))
                    .forEach(entry1 -> {
                        String username = entry1.getKey();
                        int points = entry1.getValue();

                        System.out.printf("%d. %s <::> %d%n", position[0], username, points);
                        position[0]++;
                    });
        });

        System.out.println("Individual standings: ");

        final int[] position = {1};
        totalPoints
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(entry -> {
                    String username = entry.getKey();
                    int points = entry.getValue();

                    System.out.printf("%d. %s -> %d%n", position[0], username, points);
                    position[0]++;
                });
    }
}