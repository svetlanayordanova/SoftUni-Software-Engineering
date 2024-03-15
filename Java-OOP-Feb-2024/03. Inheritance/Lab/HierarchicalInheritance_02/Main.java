package inheritance.HierarchicalInheritance_02;

import inheritance.HierarchicalInheritance_02.Cat;
import inheritance.HierarchicalInheritance_02.Dog;

public class Main {
    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.eat();
        dog.bark();

        Cat cat = new Cat();
        cat.eat();
        cat.meow();
    }
}