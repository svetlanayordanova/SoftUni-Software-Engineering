package data_types_and_variables_exercise;

import java.util.Scanner;
public class Snowballs_11 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int countBalls = Integer.parseInt(scanner.nextLine());
        double maxValue = Double.MIN_VALUE;
        int snowballSnowBiggest = 0;
        int snowballTimeBiggest = 0;
        int snowballQualityBiggest = 0;

        for (int i = 1; i <= countBalls; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            double snowballValue = Math.pow(snowballSnow / snowballTime, snowballQuality);

            if (snowballValue > maxValue) {
                maxValue = snowballValue;
                snowballSnowBiggest = snowballSnow;
                snowballTimeBiggest = snowballTime;
                snowballQualityBiggest = snowballQuality;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)",
                snowballSnowBiggest, snowballTimeBiggest, maxValue, snowballQualityBiggest);
    }
}
