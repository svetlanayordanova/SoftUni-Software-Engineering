package maps_lambda_and_streamAPI_more_exercise;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MOBAChallenger_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> playerPool = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Season end")) {
            String[] inputParts = input.split(" ");

            if (input.contains("->")) {
                String player = inputParts[0];
                String position = inputParts[2];
                int skill = Integer.parseInt(inputParts[4]);

                if (!playerPool.containsKey(player)) {
                    playerPool.put(player, new LinkedHashMap<>());
                    playerPool.get(player).put(position, skill);
                } else {
                    if (!playerPool.get(player).containsKey(position)) {
                        playerPool.get(player).put(position, skill);
                    } else {
                        if (skill > playerPool.get(player).get(position)) {
                            playerPool.get(player).put(position, skill);
                        }
                    }
                }
            } else if (input.contains("vs")) {
                String firstPlayer = inputParts[0];
                String secondPlayer = inputParts[2];

                List<String> firstPlayerPositions = new ArrayList<>();
                List<String> secondPlayerPositions = new ArrayList<>();

                AtomicInteger firstPlayerTotalSkillPoints = new AtomicInteger();
                AtomicInteger secondPlayerTotalSkillPoints = new AtomicInteger();

                if (playerPool.containsKey(firstPlayer) && playerPool.containsKey(secondPlayer)) {
                    playerPool.entrySet().forEach(entry -> {
                        String playerInPool = entry.getKey();
                        Map<String, Integer> positionsAndSkills = entry.getValue();
                        if (firstPlayer.equals(playerInPool)) {
                            for (Map.Entry<String, Integer> entry1 : positionsAndSkills.entrySet()) {
                                String firstPlayerPosition = entry1.getKey();
                                int firstPlayerSkill = entry1.getValue();

                                firstPlayerPositions.add(firstPlayerPosition);
                                firstPlayerTotalSkillPoints.addAndGet(firstPlayerSkill);
                            }
                        } else if (secondPlayer.equals(playerInPool)) {
                            for (Map.Entry<String, Integer> entry1 : positionsAndSkills.entrySet()) {
                                String secondPlayerPosition = entry1.getKey();
                                int secondPlayerSkill = entry1.getValue();

                                secondPlayerPositions.add(secondPlayerPosition);
                                secondPlayerTotalSkillPoints.addAndGet(secondPlayerSkill);
                            }
                        }
                    });
                }

                firstPlayerPositions.forEach(positionFirstPlayer -> {
                    secondPlayerPositions.forEach(positionSecondPlayer -> {
                        if (positionFirstPlayer.equals(positionSecondPlayer)) {
                            if (firstPlayerTotalSkillPoints.get() > secondPlayerTotalSkillPoints.get()) {
                                playerPool.remove(secondPlayer);
                            } else {
                                playerPool.remove(firstPlayer);
                            }
                        }
                    });
                });
            }

            input = scanner.nextLine();
        }

        Map<String, Integer> totalPoints = new LinkedHashMap<>();

        playerPool.entrySet().forEach(entry -> {
            String player = entry.getKey();
            Map<String, Integer> positionsAndSkills = entry.getValue();
            int totalPointsPerPlayer = 0;

            for (Map.Entry<String, Integer> entry1 : positionsAndSkills.entrySet()) {
                int points = entry1.getValue();
                totalPointsPerPlayer += points;
            }

            totalPoints.put(player, totalPointsPerPlayer);
        });

        totalPoints
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(entry -> {
                    String player = entry.getKey();
                    int points = entry.getValue();

                    System.out.printf("%s: %d skill%n", player, points);

                    playerPool.entrySet().forEach(entry1 -> {
                        String playerInPool = entry1.getKey();
                        Map<String, Integer> positionsAndSkills = entry1.getValue();

                        positionsAndSkills
                                .entrySet()
                                .stream()
                                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                                    .thenComparing(Map.Entry.comparingByKey()))
                            .forEach(entry2 -> {
                                String position = entry2.getKey();
                                int skillPoints = entry2.getValue();

                                if (playerInPool.equals(player)) {
                                    System.out.printf("- %s <::> %d%n", position, skillPoints);
                                }
                            });
                    });
                });
    }
}