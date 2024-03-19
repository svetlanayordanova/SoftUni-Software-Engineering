package polymorphism_exercise.VehiclesExtension_02;

public interface Vehicle {
    String drive(double distance);
    void refuel(double liters);
    default void setEmpty(boolean empty) {

    }
}
