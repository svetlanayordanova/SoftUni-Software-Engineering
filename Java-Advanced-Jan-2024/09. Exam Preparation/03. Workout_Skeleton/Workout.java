package workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Workout {
    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (this.exercises.size() < this.exerciseCount) {
            this.exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        for (Exercise exercise : this.exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                this.exercises.remove(exercise);
                return true;
            }
        }

        return false;
    }

    public Exercise getExercise(String name, String muscle) {
        return this.exercises.stream().filter(e -> e.getName().equals(name) &&
                e.getMuscle().equals(muscle)).findFirst().orElse(null);
    }

    public Exercise getMostBurnedCaloriesExercise() {
        return this.exercises.stream().max(Comparator.comparingInt(Exercise::getBurnedCalories)).orElse(null);
    }

    public int getExerciseCount() {
        return this.exercises.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Workout type: " + this.type).append(System.lineSeparator());
        this.exercises.forEach(e -> stringBuilder.append(e.toString()).append(System.lineSeparator()));

        return stringBuilder.toString();
    }
}
