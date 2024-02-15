package sets_and_maps_exercise;

import java.util.*;

public class UserLogs_08 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Map<String, Integer>> userLogs = new TreeMap<>();

        while (!"end".equals(input)) {
            String[] tokens = input.split("\\s+");
            String IP = tokens[0];
            String user = tokens[2];

            String ipAddress = IP.substring(3);
            String username = user.substring(5);

            userLogs.putIfAbsent(username, new LinkedHashMap<>());
            userLogs.get(username).putIfAbsent(ipAddress, 0);
            int newCount = userLogs.get(username).get(ipAddress) + 1;
            userLogs.get(username).put(ipAddress, newCount);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Integer>> entry : userLogs.entrySet()) {
            String username = entry.getKey();
            Map<String, Integer> ipAddressesCount = entry.getValue();

            System.out.printf("%s: %n", username);

            int size = ipAddressesCount.size();

           for (Map.Entry<String, Integer> entry1 : ipAddressesCount.entrySet()) {
               String ipAddress = entry1.getKey();
               int count = entry1.getValue();

               if (size > 1) {
                   System.out.printf("%s => %d, ", ipAddress, count);
               } else {
                   System.out.printf("%s => %d.%n", ipAddress, count);
               }

               size--;
           }
        }
    }
}