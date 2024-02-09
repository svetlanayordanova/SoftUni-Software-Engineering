package sets_and_maps;

import java.util.*;
import java.util.stream.Collectors;

public class AverageStudentsGrades_05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentGrades = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String studentName = input[0];
            double grade = Double.parseDouble(input[1]);

            studentGrades.putIfAbsent(studentName, new ArrayList<>());
            studentGrades.get(studentName).add(grade);
        }

        studentGrades.entrySet().forEach(entry -> {
            String studentName = entry.getKey();
            List<Double> grades = entry.getValue();
            String result = grades.stream()
                    .map(g -> String.format("%.2f", g))
                    .collect(Collectors.joining(" "));

            double averageGrade = grades.stream().mapToDouble(a -> a).average().orElse(0.0);

            System.out.printf("%s -> %s (avg: %.2f)%n", studentName, result, averageGrade);
        });
    }
}