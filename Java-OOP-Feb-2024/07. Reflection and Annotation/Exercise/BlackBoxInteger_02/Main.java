package reflection_and_annotation_exercise.BlackBoxInteger_02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> blackBoxIntClass = BlackBoxInt.class;
        Constructor<BlackBoxInt> privateConstructor = blackBoxIntClass.getDeclaredConstructor();

        privateConstructor.setAccessible(true);

        BlackBoxInt blackBoxInt = privateConstructor.newInstance();

        String input = scanner.nextLine();

        while (!"END".equals(input)) {
            String[] tokens = input.split("_");
            String methodName = tokens[0];
            int parameter = Integer.parseInt(tokens[1]);

            Method method = blackBoxIntClass.getDeclaredMethod(methodName, int.class);

            method.setAccessible(true);

            method.invoke(blackBoxInt, parameter);

            Field innerValue = blackBoxIntClass.getDeclaredField("innerValue");
            innerValue.setAccessible(true);
            System.out.println(innerValue.get(blackBoxInt));

            input = scanner.nextLine();
        }
    }
}
