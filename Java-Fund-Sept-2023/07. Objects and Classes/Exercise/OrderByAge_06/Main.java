package objects_and_classes_exercise.OrderByAge_06;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Person> peopleList = new ArrayList<>();
        String data = scanner.nextLine();

        while (!data.equals("End")) {
            String name = data.split(" ")[0];
            String id = data.split(" ")[1];
            int age = Integer.parseInt(data.split(" ")[2]);

            Person person = new Person(name, id, age);
            peopleList.add(person);

            data = scanner.nextLine();
        }

        peopleList.sort(Comparator.comparing(Person::getAge));

        for (Person person : peopleList) {
            System.out.println(person.getName() + " with ID: " + person.getId() + " is " + person.getAge() + " years old.");
        }
    }
}