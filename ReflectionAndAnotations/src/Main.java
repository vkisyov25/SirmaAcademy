import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class reflection = Reflection.class;
        System.out.println(reflection);
        System.out.println(reflection.getSuperclass());
        Class[] interfaces = reflection.getInterfaces();
        Arrays.stream(interfaces).forEach(e-> System.out.println(e));
        Object instance = reflection.getDeclaredConstructor().newInstance();
        System.out.println(instance);
    }
}