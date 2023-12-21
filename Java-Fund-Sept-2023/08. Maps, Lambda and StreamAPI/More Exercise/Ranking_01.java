package maps_lambda_and_streamAPI_more_exercise;

import java.util.*;

public class Ranking_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, String> contestPasswords = new LinkedHashMap<>();
        Map<String, Map<String, Integer>> userContests = new TreeMap<>();

        String firstInput = scanner.nextLine();

        while (!firstInput.equals("end of contests")) {
            String[] firstInputParts = firstInput.split(":");
            String contest = firstInputParts[0];
            String passwordForContest = firstInputParts[1];

            contestPasswords.put(contest, passwordForContest);

            firstInput = scanner.nextLine();
        }

        String secondInput = scanner.nextLine();

        while (!secondInput.equals("end of submissions")) {
            String[] secondInputParts = secondInput.split("=>");
            String contest = secondInputParts[0];
            String password = secondInputParts[1];
            String username = secondInputParts[2];
            int points = Integer.parseInt(secondInputParts[3]);


            if (contestPasswords.containsKey(contest) && password.equals(contestPasswords.get(contest))) {
                if (!userContests.containsKey(username)) {
                    userContests.put(username, new LinkedHashMap<>());
                    userContests.get(username).put(contest, points);
                } else {
                    if (!userContests.get(username).containsKey(contest)) {
                        userContests.get(username).put(contest, points);
                    } else {
                        if (points > userContests.get(username).get(contest)) {
                            userContests.get(username).put(contest, points);
                        }
                    }
                }
            }

            secondInput = scanner.nextLine();
        }

        String bestUser = "";
        int maxPoints = 0;

        for (Map.Entry<String, Map<String, Integer>> entry : userContests.entrySet()) {
            int totalPoints = 0;

            String user = entry.getKey();
            Map<String, Integer> userPoints = entry.getValue();
            for (Map.Entry<String, Integer> entry1 : userPoints.entrySet()) {
                int points = entry1.getValue();
                totalPoints += points;
            }

            if (totalPoints > maxPoints) {
                maxPoints = totalPoints;
                bestUser = user;
            }
        }

        System.out.printf("Best candidate is %s with total %d points.%n", bestUser, maxPoints);
        System.out.println("Ranking: ");

        userContests.entrySet().forEach(entry -> {
            String user = entry.getKey();
            Map<String, Integer> userPoints = entry.getValue();
            System.out.println(user);
            userPoints
                    .entrySet()
                    .stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .forEach(entry1 -> {
                        String contest = entry1.getKey();
                        int points = entry1.getValue();
                        System.out.printf("#  %s -> %d%n", contest, points);
                    });
        });
    }
}