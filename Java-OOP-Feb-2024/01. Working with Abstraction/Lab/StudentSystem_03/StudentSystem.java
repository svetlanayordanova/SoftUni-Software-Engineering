package working_with_abstraction.StudentSystem_03;

import working_with_abstraction.StudentSystem_03.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem()
    {
        this.repo = new HashMap<>();
    }

    private Map<String, Student> getRepo() {
        return this.repo;
    }

    public void parseCommand(String... args) {
        switch (args[0]) {
            case "Create":
                var student = this.create(args);
                this.getRepo().putIfAbsent(student.getName(), student);
                break;
            case "Show":
                var name = args[1];
                student = this.getRepo().get(name);
                if (student != null) {
                    final var show = this.show(student);
                    System.out.println(show);
                }
                break;
        }
    }

    public Student create(String... args) {
        var name = args[1];
        var age = Integer.parseInt(args[2]);
        var grade = Double.parseDouble(args[3]);
        return new Student(name, age, grade);
    }

    private String show(Student student) {
        String view = String.format("%s is %s years old.",student.getName(),student.getAge());

        if (student.getGrade() >= 5.00)
        {
            view += " Excellent student.";
        }
        else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50)
        {
            view += " Average student.";
        }
        else
        {
            view += " Very nice person.";
        }
        return view;
    }
}
