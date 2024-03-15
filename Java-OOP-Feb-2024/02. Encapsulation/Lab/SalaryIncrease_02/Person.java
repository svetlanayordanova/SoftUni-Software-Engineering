package encapsulation.SalaryIncrease_02;

import java.text.DecimalFormat;

public class Person {
    private final static String TO_STRING_TEMPLATE = "%s %s gets %s leva.";
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    private double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("0.0##");
        return String.format(TO_STRING_TEMPLATE, this.getFirstName(), this.getLastName(), format.format(this.getSalary()));
    }

    public void increaseSalary(double bonus) {
        bonus = this.getAge() < 30 ? bonus / 2 : bonus;
        this.setSalary(this.getSalary() + (this.getSalary() * bonus) / 100);
    }
}