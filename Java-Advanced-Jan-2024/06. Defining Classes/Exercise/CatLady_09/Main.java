package defining_classes_exercise.CatLady_09;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        List<Cat> catList = new ArrayList<>();

        while (!"End".equals(line)) {
            String[] tokens = line.split("\\s+");
            String type = tokens[0];
            String name = tokens[1];
            double parameter = Double.parseDouble(tokens[2]);

            Cat cat;

            switch (type) {
                case "Siamese":
                    cat = new Siamese(name, type, parameter);
                    break;
                case "Cymric":
                    cat = new Cymric(name, type, parameter);
                    break;
                default:
                    cat = new StreetExtraordinaire(name, type, parameter);
                    break;
            }

            catList.add(cat);

            line = scanner.nextLine();
        }

        String catName = scanner.nextLine();

        Cat searchedCat = catList.stream()
                .filter(cat -> cat.getName().equals(catName))
                .findFirst()
                .get();

        System.out.println(searchedCat);
    }
}