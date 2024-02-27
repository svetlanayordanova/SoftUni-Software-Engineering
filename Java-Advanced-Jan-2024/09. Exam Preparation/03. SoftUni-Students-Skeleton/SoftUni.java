package softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {
    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public List<Student> getData() {
        return data;
    }

    public int getCount() {
        return this.data.size();
    }

    public String insert(Student student) {
        if (this.data.size() < this.capacity) {
            if (this.data.contains(student)) {
                return "Student is already in the hall.";
            }
            this.data.add(student);
        }
        return "The hall is full.";
    }

    public String remove(Student student) {
        if (!this.data.contains(student)) {
            return "Student not found.";
        }
        this.data.remove(student);
        return String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
    }

    public Student getStudent(String firstName, String lastName) {
        return this.data.stream().filter(student -> student.getFirstName().equals(firstName)
                && student.getLastName().equals(lastName)).findFirst().orElse(null);
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Hall size: " + this.data.size()).append(System.lineSeparator());
        this.data.forEach(student -> stringBuilder.append(student.toString()).append(System.lineSeparator()));

        return stringBuilder.toString();
    }
}