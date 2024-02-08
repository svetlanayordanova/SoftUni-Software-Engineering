package sets_and_maps;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation_08 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Double[]> graduationList = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            String[] gradesStrings = scanner.nextLine().split(" ");
            Double[] grades = new Double[gradesStrings.length];

            for (int j = 0; j < gradesStrings.length; j++) {
                grades[j] = Double.parseDouble(gradesStrings[j]);
            }

            graduationList.put(name, grades);
        }

        for (Map.Entry<String, Double[]> entry : graduationList.entrySet()) {
            String name = entry.getKey();
            Double[] grades = entry.getValue();

            double averageGrade = Arrays.stream(grades).toList().stream().mapToDouble(a -> a).average().orElse(0.0);

            System.out.println(name + " is graduated with " + averageGrade);
        }
    }
}