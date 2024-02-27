package bakery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (this.employees.size() < this.capacity) {
            this.employees.add(employee);
        }
    }

    public boolean remove(String name) {
        Employee employee = this.employees.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (employee == null) {
            return false;
        }

        return this.employees.remove(employee);
    }

    public Employee getOldestEmployee() {
        return this.employees.stream()
                .max(Comparator.comparingInt(Employee::getAge))
                .orElse(null);
    }

    public Employee getEmployee(String name) {
        return this.employees.stream()
                .filter(employee -> employee.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Employees working at Bakery " + this.name + ":");
        this.employees.forEach(employee -> {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(employee.toString());
        });

        return stringBuilder.toString();
    }
}