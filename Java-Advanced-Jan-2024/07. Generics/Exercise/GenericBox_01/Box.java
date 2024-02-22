package generics_exercise.GenericBox_01;

public class Box<T> {
    private T data;

    public Box(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("%s: %s",
                this.data.getClass().getName(),
                this.data);
    }
}
