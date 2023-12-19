package maps_lambda_and_streamAPI_exercise;

import java.util.*;

public class StudentAcademy_06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> studentGrades = new LinkedHashMap<>();

        int countStudents = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= countStudents; i++) {
            String studentName = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!studentGrades.containsKey(studentName)) {
                studentGrades.put(studentName, new ArrayList<>());
            }

            studentGrades.get(studentName).add(grade);
        }

        Map<String, Double> studentAverageGrades = new LinkedHashMap<>();

        for (Map.Entry<String, List<Double>> entry : studentGrades.entrySet()) {
            String studentName = entry.getKey();
            List<Double> grades = entry.getValue();

            double average = getAverageGrade(grades);

            if (average >= 4.50) {
                studentAverageGrades.put(studentName, average);
            }
        }

        for (Map.Entry<String, Double> entry : studentAverageGrades.entrySet()) {
            System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue());
            }
        }

    public static double getAverageGrade(List<Double> grades) {
        double sum = 0;

        for (double grade : grades) {
            sum += grade;
        }

        return sum / grades.size();
    }
}