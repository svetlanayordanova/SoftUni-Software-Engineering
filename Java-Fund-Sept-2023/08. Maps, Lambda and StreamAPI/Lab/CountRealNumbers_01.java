package maps_lambda_and_streamAPI;

import java.text.DecimalFormat;
import java.util.*;

public class CountRealNumbers_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TreeMap<Double, Integer> numbersCount = new TreeMap<>();

        double[] nums = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        for (double num : nums) {
            if (numbersCount.containsKey(num)) {
                numbersCount.put(num, numbersCount.get(num) + 1);
            } else {
                numbersCount.put(num, 1);
            }
        }

        for (Map.Entry<Double, Integer> kvp : numbersCount.entrySet()) {
            String keyFormatted = new DecimalFormat("#.####").format(kvp.getKey());
            System.out.printf("%s -> %d%n", keyFormatted, kvp.getValue());
        }
    }
}