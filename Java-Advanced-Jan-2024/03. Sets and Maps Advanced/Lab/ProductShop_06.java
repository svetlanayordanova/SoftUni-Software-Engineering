package sets_and_maps;

import java.util.*;

public class ProductShop_06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Map<String, Double>> products = new TreeMap<>();

        while (!"Revision".equals(input)) {
            String[] tokens = input.split(", ");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            products.putIfAbsent(shop, new LinkedHashMap<>());
            products.get(shop).put(product, price);

            input = scanner.nextLine();
        }

        products.entrySet().forEach(entry -> {
            String shop = entry.getKey();
            Map<String, Double> productsPrices = entry.getValue();

            System.out.printf("%s->%n", shop);

            productsPrices.entrySet().forEach(entry1 -> {
                String product = entry1.getKey();
                double price = entry1.getValue();

                System.out.printf("Product: %s, Price: %.1f%n", product, price);
            });
        });
    }
}