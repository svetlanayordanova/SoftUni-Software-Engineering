import java.util.Scanner;
public class FuelTankPart2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String fuel = scanner.nextLine();
        double liters = Double.parseDouble(scanner.nextLine());
        String clubCard = scanner.nextLine();

        double priceGasoline = liters * 2.22;
        double priceDiesel = liters * 2.33;
        double priceGas = liters * 0.93;

        if (fuel.equals("Gasoline")) {
            if (clubCard.equals("Yes")) {
                priceGasoline = priceGasoline - (liters * 0.18);
            } else if (clubCard.equals("No")) {
                priceGasoline = liters * 2.22;
            }

            if (liters > 25) {
                priceGasoline = priceGasoline - (priceGasoline * 0.10);
            } else if (liters >= 20) {
                priceGasoline = priceGasoline - (priceGasoline * 0.08);
            }
                System.out.printf("%.2f lv.", priceGasoline);

        } else if (fuel.equals("Diesel")) {
            if (clubCard.equals("Yes")) {
                priceDiesel = priceDiesel - (liters * 0.12);
            } else if (clubCard.equals("No")) {
                priceDiesel = liters * 2.33;
            }

            if (liters > 25) {
                priceDiesel = priceDiesel - (priceDiesel * 0.10);
            } else if (liters >= 20) {
                priceDiesel = priceDiesel - (priceDiesel * 0.08);
            }
            System.out.printf("%.2f lv.", priceDiesel);

        } else if (fuel.equals("Gas")) {
            if (clubCard.equals("Yes")) {
                priceGas = priceGas - (liters * 0.08);
            } else if (clubCard.equals("No")) {
                priceGas = liters * 0.93;
            }

            if (liters > 25) {
                priceGas = priceGas - (priceGas * 0.10);
            } else if (liters >= 20) {
                priceGas = priceGas - (priceGas * 0.08);
            }
            System.out.printf("%.2f lv.", priceGas);
            }
        }
    }