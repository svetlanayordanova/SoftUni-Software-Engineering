package sets_and_maps_exercise;

import java.util.*;

public class LogsAggregator_10 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Set<String>> userIPs = new TreeMap<>();
        Map<String, Integer> userDurations = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String ip = input[0];
            String user = input[1];
            int duration = Integer.parseInt(input[2]);

            userIPs.putIfAbsent(user, new TreeSet<>());
            userIPs.get(user).add(ip);

            if (!userDurations.containsKey(user)) {
                userDurations.put(user, duration);
            } else {
                userDurations.put(user, userDurations.get(user) + duration);
            }
        }

        userIPs.entrySet()
                .forEach(entry -> {
                    String user = entry.getKey();
                    Set<String> ips = entry.getValue();
                    int duration = userDurations.get(user);

                    System.out.printf("%s: %d [%s]%n", user, duration, String.join(", ", ips));
                });
    }
}