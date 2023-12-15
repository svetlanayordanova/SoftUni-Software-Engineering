package maps_lambda_and_streamAPI_exercise;

import java.util.*;

public class CompanyUsers_08 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> companyEmployees = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String companyName = input.split(" -> ")[0];
            String employeeId = input.split(" -> ")[1];

            if (companyEmployees.containsKey(companyName)) {
                List<String> currentEmployees = companyEmployees.get(companyName);

                if (!currentEmployees.contains(employeeId)) {
                    companyEmployees.get(companyName).add(employeeId);
                }
            } else {
                companyEmployees.put(companyName, new ArrayList<>());
                companyEmployees.get(companyName).add(employeeId);
            }

            input = scanner.nextLine();
        }

        companyEmployees.
                entrySet().
                forEach(entry -> {
                    System.out.println(entry.getKey());
            entry.getValue().
                    forEach(employee ->
                    System.out.println("-- " + employee));
        });
    }
}