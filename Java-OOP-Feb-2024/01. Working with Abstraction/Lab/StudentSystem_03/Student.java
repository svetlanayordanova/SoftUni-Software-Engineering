package working_with_abstraction.StudentSystem_03;

public class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.setName(name);
        this.setAge(age);
        this.setGrade(grade);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public double getGrade() {
        return this.grade;
    }

    private void setGrade(double grade) {
        this.grade = grade;
    }
}
