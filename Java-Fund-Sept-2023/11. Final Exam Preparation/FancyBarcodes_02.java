package final_exam_preparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int count = 1; count <= n; count++) {
            String barcode = scanner.nextLine();

            Pattern pattern = Pattern.compile("@#+(?<barcodeText>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+");
            Matcher matcher = pattern.matcher(barcode);

            if (matcher.find()) {
                String textBarcode = matcher.group("barcodeText");

                StringBuilder productGroup = new StringBuilder();

                for (char symbol : textBarcode.toCharArray()) {
                    if (Character.isDigit(symbol)) {
                        productGroup.append(symbol);
                    }
                }

                if (productGroup.length() == 0) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.println("Product group: " + productGroup);
                }
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}